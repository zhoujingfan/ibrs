package com.buptsse.ibrs.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.LocaleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.buptsse.ibrs.model.Enterprise;
import com.buptsse.ibrs.model.Invoice;
import com.buptsse.ibrs.model.InvoiceExpense;
import com.buptsse.ibrs.model.User;
import com.buptsse.ibrs.model.UserAndEnterprise;
import com.buptsse.ibrs.model.UserInfo;
import com.buptsse.ibrs.service.EnterpriseService;
import com.buptsse.ibrs.service.InvoiceService;
import com.buptsse.ibrs.service.UserAndEnterpriseService;
import com.buptsse.ibrs.service.UserService;
import com.mysql.fabric.xmlrpc.base.Array;

@Controller
public class AddInvoiceController {
	@Autowired
	UserAndEnterpriseService followService;
	@Autowired
	UserService userService;
	@Autowired
	EnterpriseService enterpriseService;
	@Autowired
	InvoiceService invoiceService;

	/**
	 * 跳转到查看我的发票界面
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = { "myInvoice" })
	private ModelAndView MyInvoice(HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<UserAndEnterprise> myEnterprise = followService.UserGetMyEnterprise(user.getUserInfo().getId());
		UserInfo userInfo = userService.getByPhoneNumber(user.getPhoneNumber()).getUserInfo();
		List<InvoiceExpense> invoiceExpense = invoiceService.getAllByUserInfo(userInfo.getId());

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("invoiceExpense", invoiceExpense);
		modelAndView.addObject("myEnterprise", myEnterprise);
		modelAndView.setViewName("user/invoice/myinvoice");
		return modelAndView;
	}

	/**
	 * 添加成功
	 * 
	 * @param enterprise
	 * @param invoiceId
	 * @param invoiceNumber
	 * @param invoicePassword
	 * @param invoiceEnterprise
	 * @param taxNumber
	 * @param invoicePayee
	 * @param invoiceDate
	 * @param invoicePayer
	 * @param invoiceDetails
	 * @param invoiceSum
	 * @param session
	 * @return
	 */
	@RequestMapping(value = { "add_submit" })
	private String AddSubmit(String enterprise, long invoiceId, long invoiceNumber, String invoicePassword,
			String invoiceEnterprise, long taxNumber, String invoicePayee, String invoiceDate, String invoicePayer,
			String invoiceDetails, Integer invoiceSum, HttpSession session) {
		InvoiceExpense invoiceUpload = new InvoiceExpense();
		Enterprise enterP = enterpriseService.getByName(enterprise);
		User user = (User) session.getAttribute("user");
		UserInfo userInfo = user.getUserInfo();
		Invoice invoice = new Invoice();
		invoice.setInvoiceId(invoiceId);
		invoice.setNumber(invoiceNumber);
		invoice.setPassword(invoicePassword);
		invoice.setPayEnterprise(invoiceEnterprise);
		invoice.setTaxNumber(taxNumber);
		invoice.setPayee(invoicePayee);
		invoice.setPayer(invoicePayer);
		invoice.setDetails(invoiceDetails);
		invoice.setPaySum(invoiceSum);
		invoice.setPayData(invoiceDate);
		invoiceUpload.setUploadEnterprise(enterP);
		invoiceUpload.setUploadUser(userInfo);
		invoiceUpload.setInvoice(invoice);
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		invoiceUpload.setUploadTime(time);
		invoiceService.addUploadInvoice(invoiceUpload);
		return "user/invoice/add_success";
	}

	@RequestMapping(value = { "add_review" })
	private ModelAndView BatchSubmit(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);

		List<FileItem> items = upload.parseRequest(request);
		
		ModelAndView modelAndView = new ModelAndView();
		List<List<String>> invoices = new ArrayList<List<String>>();
		for (FileItem item : items) {
			if (!item.isFormField()) {
				String filename = item.getName();
				InputStream in = item.getInputStream();
				byte[] buffer = new byte[1024];
				int len = 0;
				filename = "D:\\file\\" + filename;
				OutputStream out = new FileOutputStream(filename);
				while ((len = in.read(buffer)) != -1) {
					out.write(buffer, 0, len);
				}
				out.close();
				in.close();
				InputStream is = new FileInputStream(filename);
				XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
				for (int xssfSheetNum = 0; xssfSheetNum < xssfWorkbook.getNumberOfSheets(); xssfSheetNum++) {
					XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(xssfSheetNum);
					if (xssfSheet != null) {
						XSSFRow firstRow = xssfSheet.getRow(0);
						List<String> head = new ArrayList<String>();
						for(int i =0;i<firstRow.getLastCellNum();i++){
							XSSFCell firstCell = firstRow.getCell(i);
							head.add(firstCell.toString());
						}
						modelAndView.addObject("head", head);
						for (int xssfRowNum = 1; xssfRowNum < xssfSheet.getLastRowNum(); xssfRowNum++) {
							XSSFRow xssfRow = xssfSheet.getRow(xssfRowNum);
							List<String> row = new ArrayList<String>();
							if (xssfRow != null) {
								for (int cellNum = 0; cellNum < xssfRow.getLastCellNum(); cellNum++) {
									XSSFCell xssfCell = xssfRow.getCell(cellNum);
									row.add(getStringVal(xssfCell));
								}
								invoices.add(row);
							}
						}
					}
				}
				modelAndView.addObject("invoices", invoices);
				session.setAttribute("addInvoices", invoices);
				
				File file = new File(filename);
					file.delete();
			}
			else 
			{
				String upload_enterprise = item.getString("utf-8");
				session.setAttribute("upload_enterprise", upload_enterprise);
			}
		}
		modelAndView.setViewName("user/invoice/add_review");
		return modelAndView;
	}

	
	@SuppressWarnings("deprecation")
	private static String getStringVal(XSSFCell cell){
		switch(cell.getCellTypeEnum()){
		  case NUMERIC:
			  long l = Math.round(cell.getNumericCellValue());
              return l + "";
          case STRING:
              return cell.getRichStringCellValue().toString();
          case FORMULA:
              return cell.getCellFormula();
          case BLANK:
              return "";
          case BOOLEAN:
              return cell.getBooleanCellValue() ? "TRUE" : "FALSE";
          case ERROR:
              return ErrorEval.getText(cell.getErrorCellValue());
          default:
              return "Unknown Cell Type: " + cell.getCellTypeEnum();
     
		}
	}
	@RequestMapping(value = { "add_invoice" })
	private ModelAndView AddInvoice(HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<UserAndEnterprise> myEnterprise = followService.UserGetMyEnterprise(user.getUserInfo().getId());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("myEnterprise", myEnterprise);
		modelAndView.setViewName("user/invoice/addinvoice");
		return modelAndView;
	}

	@RequestMapping(value = { "add_batch" })
	private ModelAndView AddBatch(HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<UserAndEnterprise> myEnterprise = followService.UserGetMyEnterprise(user.getUserInfo().getId());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("myEnterprise", myEnterprise);
		modelAndView.setViewName("user/invoice/add_batch");
		return modelAndView;
	}
	
	@RequestMapping(value={"add_invoice_submit"})
	private String AddInvoiceSubmit(HttpSession session){
		User user = (User) session.getAttribute("user");
		UserInfo uploadUser = user.getUserInfo();
		String enterpriseName = (String) session.getAttribute("upload_enterprise");
		Enterprise enterprise = enterpriseService.getByName(enterpriseName);
		List<List<String>> invoices = new ArrayList<List<String>>();
		invoices = (List<List<String>>) session.getAttribute("addInvoices");
		List<Invoice> invoiceList = new ArrayList<Invoice>();
		Invoice invoice = new Invoice();
		List<String> stringList = new ArrayList<String>();
		List<InvoiceExpense> invoiceExpense = new ArrayList<InvoiceExpense>();
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		InvoiceExpense inE = new InvoiceExpense();
		for(int i =0;i<invoices.size();i++){
			stringList = invoices.get(i);
			System.out.println(stringList);
			invoice.setInvoiceId(Long.parseLong(stringList.get(0)));
			invoice.setNumber(Long.parseLong(stringList.get(1)));
			invoice.setPassword(stringList.get(2));
			invoice.setPayEnterprise(stringList.get(3));
			invoice.setTaxNumber(Long.parseLong(stringList.get(4)));
			invoice.setPayData(stringList.get(5));
			invoice.setPayee(stringList.get(6));
			invoice.setPayer(stringList.get(7));
			invoice.setDetails(stringList.get(8));
			invoice.setPaySum(Integer.parseInt(stringList.get(9)));
			invoiceList.add(invoice);
			inE.setInvoice(invoice);
			inE.setUploadTime(time);
			inE.setUploadEnterprise(enterprise);
			inE.setUploadUser(uploadUser);
			invoiceService.addUploadInvoice(inE);
		}
		
		return "user/invoice/add_success";
	}
}
