
package com.peanut.p2p.code;

import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.code.model.entity.Bank;
import com.peanut.p2p.code.model.entity.Pic;
import com.peanut.p2p.code.model.query.BankQueryObject;
import com.peanut.p2p.code.service.BankService;
import com.peanut.p2p.code.service.PicService;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.pagination.page.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;

/**
 * @author my
 * @version 1.0
 */
@Controller
public class BankController {
    private static final String BANK_PAGE_MODEL_NAME = "bankPage";

    private static final String BANK_QUERY_MODEL_NAME = "bankQueryObject";

    private static final String BANK_MODEL_NAME = "bankModel";

    @Resource
    private BankService bankService;

    @Resource
    private PicService picService;


    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    @RequestMapping(value = "/bank/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(BANK_QUERY_MODEL_NAME) BankQueryObject bankQueryObject,
            Model model) {
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(bankQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<Bank> bankPage = pageService
                .queryDefaultPageSizePage(queryInfo);
        model.addAttribute(BANK_PAGE_MODEL_NAME, bankPage);
        model.addAttribute(BANK_QUERY_MODEL_NAME, bankQueryObject);
        return "code/bank/index";
    }

    @RequestMapping(value = "/bank/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(BANK_MODEL_NAME)) {
            model.addAttribute(BANK_MODEL_NAME, new Bank());
        }
        return "code/bank/add";
    }

    @RequestMapping(value = "/bank/add", method = RequestMethod.POST)
    public String add (
            Model model,
            @RequestParam("content") MultipartFile file,
            @ModelAttribute(BANK_MODEL_NAME) @Valid Bank bank,
            BindingResult result
           ) {
        if (result.hasErrors()) {
            model.addAttribute(BANK_MODEL_NAME, bank);
            return gotoUpdate(bank.getBank_id(), model);
        }

        Pic pic = new Pic();
        try {
            pic.setContent(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*上传图片*/
     //   bankService.uploadImage(file,bank);
        bankService.doSave(pic,bank);

        return "code/bank/success";
    }

    @RequestMapping(value = "/bank/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable("id") Integer id, Model model) {
        if (!model.containsAttribute(BANK_MODEL_NAME)) {
            Bank bank = bankService.queryByID(id);
            model.addAttribute(BANK_MODEL_NAME, bank);
        }
        return "code/bank/update";
    }

    @RequestMapping(value = "/bank/{id}/update", method = RequestMethod.POST)
    public String update(
            @RequestParam("content") MultipartFile file,
            @ModelAttribute(BANK_MODEL_NAME) @Valid Bank bank,
            BindingResult result,
            Model model) throws IOException {
        if (result.hasErrors()) {
            model.addAttribute(BANK_MODEL_NAME, bank);
            return gotoUpdate(bank.getBank_id(), model);
        }
        Pic pic = new Pic();
        pic.setId(bank.getPicId());
        pic.setContent(file.getBytes());
        bankService.doUpdate(pic,bank);
        return "code/bank/success";
    }

    @RequestMapping(value = "/bank/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        bankService.doDelete(id);
        return "code/bank/success";
    }

//    @RequestMapping(value = "/Bank/delete", method = RequestMethod.DELETE)
//    public String batchDelete(
//            @RequestParam("batchDeleteIds") Integer[] batchDeleteIds) {
//        BankService.doDelete(batchDeleteIds);
//        return "code/Bank/success";
//    }
    @RequestMapping(value = "/bank/{picId}/show", method = RequestMethod.GET)
    public void showImage(@PathVariable Integer picId,HttpServletResponse response) throws IOException{


       Pic pic =  bankService.getPicById(picId);
       // data = bank.getBank_img();
        byte[]  data = pic.getContent();

    if (data != null) {
        // 输出
        response.setContentType("image/jpeg");
        OutputStream outs = response.getOutputStream();
        outs.write(data, 0, data.length);
        outs.flush();
    }

}

}