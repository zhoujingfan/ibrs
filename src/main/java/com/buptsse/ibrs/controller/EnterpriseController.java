package com.buptsse.ibrs.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.text.StrLookup;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.buptsse.ibrs.model.Enterprise;
import com.buptsse.ibrs.model.InvoiceExpense;
import com.buptsse.ibrs.model.UserAndEnterprise;
import com.buptsse.ibrs.model.UserInfo;
import com.buptsse.ibrs.service.EnterpriseService;
import com.buptsse.ibrs.service.InvoiceService;
import com.buptsse.ibrs.service.UserAndEnterpriseService;
import com.buptsse.ibrs.service.UserService;

@Controller
public class EnterpriseController {
	@Autowired
	UserService userService;
	@Autowired
	EnterpriseService enterpriseService;
	@Autowired
	UserAndEnterpriseService followService;
	@Autowired
	InvoiceService invoiceServoce;
	
	@RequestMapping(value={"myEmployee"})
	private ModelAndView MyEmloyee(HttpSession session){
		Enterprise enterprise = (Enterprise) session.getAttribute("enterprise");
		List<UserAndEnterprise> follows = followService.EnterpriseGetEmployee(enterprise.getId());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("follows", follows);
		modelAndView.setViewName("enterprise/employee/employee");
		return modelAndView;
	}
	
	
	@RequestMapping(value={"enterprise_show_main"})
	private String ShowMain(){
		return "enterprise/main";
	}
	
	@RequestMapping(value={"enterprise_invoice"})
	private ModelAndView EnterpriseInvoice(HttpSession session){
		
		Enterprise enterprise = (Enterprise) session.getAttribute("enterprise");
		List<InvoiceExpense> invoices = enterpriseService.getNotExpenseInvoices(enterprise);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("invoicesNotExpense", invoices);
		modelAndView.setViewName("enterprise/invoice/show_invoice");
		return modelAndView;
	}
	
	@RequestMapping(value={"expense"})
	private String OneKeyExpense(HttpSession session){
		Enterprise enterprise = (Enterprise) session.getAttribute("enterprise");
		List<InvoiceExpense> invoices = enterpriseService.getNotExpenseInvoices(enterprise);
		enterpriseService.UpdateMessage(invoices);
		return "redirect:enterprise_invoice";
	}
	
	@RequestMapping(value={"expensed"})
	private ModelAndView ShowExpensed(HttpSession session){
		Enterprise enterprise = (Enterprise) session.getAttribute("enterprise");
		List<InvoiceExpense> invoices = enterpriseService.getExpenseInvoices(enterprise);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("invoiceExpensed", invoices);
		modelAndView.setViewName("enterprise/invoice/show_expensed");
		return modelAndView;
	}
	
	@RequestMapping(value={"add_employee"})
	private String EnterpriseAddEmployee(HttpSession session){
		return "enterprise/employee/add_employee";
	}
	
	@RequestMapping(value={"add_employee_submit"})
	private ModelAndView AddEmployeeSubmit(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws FileUploadException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> items = upload.parseRequest(request);
		ModelAndView modelAndView = new ModelAndView();
		List<List<String>> employee = new ArrayList<List<String>>();
		
		for(FileItem item:items){
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
					for (int xssfRowNum = 1; xssfRowNum <= xssfSheet.getLastRowNum(); xssfRowNum++) {
						System.out.println(xssfSheet.getLastRowNum());
						XSSFRow xssfRow = xssfSheet.getRow(xssfRowNum);
						List<String> row = new ArrayList<String>();
						if (xssfRow != null) {
							for (int cellNum = 0; cellNum < xssfRow.getLastCellNum(); cellNum++) {
								XSSFCell xssfCell = xssfRow.getCell(cellNum);
								row.add(getStringVal(xssfCell));
							}
							employee.add(row);
						}
					}
				}
			}
			
			
			modelAndView.addObject("employee",employee);
			File file = new File(filename);
			file.delete();
		}
		Enterprise enterprise = (Enterprise) session.getAttribute("enterprise");
		List<UserAndEnterprise> follows = new ArrayList<UserAndEnterprise>();
		UserInfo userInfo = new UserInfo();
		List<String> stringList = new ArrayList<String>();Date date = new Date();
		UserAndEnterprise  follow = new UserAndEnterprise();
		for(int i =0;i<employee.size();i++){
			stringList = employee.get(i);
			userInfo.setTruename(stringList.get(0));
			userInfo.setIdNumber(stringList.get(1));
			userInfo.setBirthday(stringList.get(2));
			userInfo.setAddress(stringList.get(3));
			userInfo.setPhoneNumber(Long.parseLong(stringList.get(4)));
			follow.setUserId(userInfo);
			follow.setEnterpriseId(enterprise);
			follow.setIfLeave("否");
			follows.add(follow);
			followService.UserAddEnterprise(userInfo, enterprise);
		}
		
		
		modelAndView.setViewName("enterprise/employee/add_success");
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
	
	@RequestMapping(value={"deleteEmployee"})
	private String DeleteEmployee(HttpSession session, Integer id){
		Enterprise enterprise = (Enterprise) session.getAttribute("enterprise");
		UserInfo userInfo = userService.getById(id);
		UserAndEnterprise record = new UserAndEnterprise();
		record.setUserId(userInfo);
		record.setEnterpriseId(enterprise);
		record = followService.getFollow(record);
		followService.deleteFollow(record.getFollowId());
		return "redirect:myEmployee";
	}
	
	@RequestMapping(value={"notPass"})
	private String NotPass(HttpSession session, long id) {
		Enterprise enterprise = (Enterprise) session.getAttribute("enterprise");
		InvoiceExpense invoice = invoiceServoce.getById(id);
		enterpriseService.NotPass(invoice);
		return "redirect:enterprise_invoice";
	}
}
