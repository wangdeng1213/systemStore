
package com.peanut.p2p.code;

import com.peanut.data.query.component.QueryInfo;
import com.peanut.data.query.helper.QueryInfoBuilder;
import com.peanut.p2p.code.model.entity.EnsureType;
import com.peanut.p2p.code.model.query.EnsureTypeQueryObject;
import com.peanut.p2p.code.service.EnsureTypeService;
import com.peanut.p2p.pagination.service.PageService;
import com.peanut.p2p.util.XmlUtil;
import com.peanut.pagination.page.Page;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author my
 * @version 1.0
 */
@Controller
public class EnsureTypeController {
    private static final String ENSURE_TYPE_PAGE_MODEL_NAME = "ensureTypePage";

    private static final String ENSURE_TYPE_QUERY_MODEL_NAME = "ensureTypeQueryObject";

    private static final String ENSURE_TYPE_MODEL_NAME = "ensureTypeModel";

    @Resource
    private EnsureTypeService ensureTypeService;

    @Resource
    private QueryInfoBuilder queryInfoBuilder;

    @Resource
    private PageService pageService;

    @RequestMapping(value = "/ensureType/query", method = RequestMethod.GET)
    public String index(
            @RequestParam(defaultValue = "1") int pageNum,
            @ModelAttribute(ENSURE_TYPE_QUERY_MODEL_NAME) EnsureTypeQueryObject ensureTypeQueryObject,
            Model model) {
        ensureTypeQueryObject.setAct_status(1);
        QueryInfo queryInfo = queryInfoBuilder.buildQueryInfo(ensureTypeQueryObject);
        queryInfo.setPageNum(pageNum);

        Page<EnsureType> ensureTypePage = pageService
                .queryDefaultPageSizePage(queryInfo);

        model.addAttribute(ENSURE_TYPE_PAGE_MODEL_NAME, ensureTypePage);
        model.addAttribute(ENSURE_TYPE_QUERY_MODEL_NAME, ensureTypeQueryObject);
        return "code/ensuretype/index";
    }

    @RequestMapping(value = "/ensureType/add", method = RequestMethod.GET)
    public String gotoAdd(Model model) {
        if (!model.containsAttribute(ENSURE_TYPE_MODEL_NAME)) {
            model.addAttribute(ENSURE_TYPE_MODEL_NAME, new EnsureType());
        }
        return "code/ensuretype/add";
    }

    @RequestMapping(value = "/ensureType/add", method = RequestMethod.POST)
    public String add(
            Model model,
            @ModelAttribute(ENSURE_TYPE_MODEL_NAME) @Valid EnsureType ensureType,
            BindingResult result,HttpServletResponse response
           ) {
   /*     if (result.hasErrors()) {
            model.addAttribute(ENSURE_TYPE_MODEL_NAME, ensureType);
            return gotoAdd(model);
        }
        ensureType.setAct_status(1);
        ensureTypeService.doSave(ensureType);*/

//        String url = "http://119.161.147.110:8088/member/bha/toRegister";
//        String platformUserNo = "用户编号";
//        String nickName = "土豪";
//        String realName = "高富帅";
//        String idCardNo = "430503198010100432";
//        String  mobile = "18688888888";
//        String email = "test@hotmail.com";
//        String notifyUrl = "/product/add";
//        String callbackUrl = "/ensureType/add";
//
//        String reg =  XmlUtil.registerXml(platformUserNo,nickName,realName,idCardNo,mobile,email,notifyUrl,callbackUrl);




        String req = "<request platformNo=\"10040011137\"><platformUserNo>majie01</platformUserNo></request>";

        HttpClient client = new HttpClient();
        client.getParams().setContentCharset("utf-8");

        PostMethod post = new PostMethod("http://119.161.147.110:8088/member/bhaexter/bhaController");

        post.addParameter("req", req);
        post.addParameter("sign", "signdata");
        post.addParameter("service", "ACCOUNT_INFO");

        try { client.executeMethod(post);

            Reader r = new InputStreamReader(post.getResponseBodyAsStream(), "utf-8");
            System.out.println(IOUtils.toString(r));} catch (IOException e) {
            e.printStackTrace();


        }
//
//        HttpClient client = new HttpClient();
//        client.getParams().setContentCharset("utf-8");
//        PostMethod postMethod = new PostMethod(url);
//        postMethod.addParameter("req",reg);
//        postMethod.addParameter("sign","signdata");
//        Reader r = null;
//        try {
//            client.executeMethod(postMethod);
//            r = new InputStreamReader(postMethod.getResponseBodyAsStream(),"utf-8");
//           System.out.println(IOUtils.toString(r));
//            return IOUtils.toString(r);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
      return null;
    }

    @RequestMapping(value = "/ensureType/{id}/update", method = RequestMethod.GET)
    public String gotoUpdate(@PathVariable("id") Integer id, Model model) {
        if (!model.containsAttribute(ENSURE_TYPE_MODEL_NAME)) {
            EnsureType ensureType = ensureTypeService.queryByID(id);
            model.addAttribute(ENSURE_TYPE_MODEL_NAME, ensureType);
        }
        return "code/ensuretype/update";
    }

    @RequestMapping(value = "/ensureType/update", method = RequestMethod.PUT)
    public String update(
            @ModelAttribute(ENSURE_TYPE_MODEL_NAME) @Valid EnsureType ensureType,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            model.addAttribute(ENSURE_TYPE_MODEL_NAME, ensureType);
            return gotoUpdate(ensureType.getId(), model);
        }
        ensureTypeService.doUpdate(ensureType);
        return "code/ensuretype/success";
    }

    @RequestMapping(value = "/ensureType/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        ensureTypeService.doUpdate(id);
        return "code/ensuretype/success";
    }

//    @RequestMapping(value = "/agent/delete", method = RequestMethod.DELETE)
//    public String batchDelete(
//            @RequestParam("batchDeleteIds") Integer[] batchDeleteIds) {
//        agentService.doDelete(batchDeleteIds);
//        return "code/agent/success";
//    }
}