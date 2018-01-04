package com.peanut.p2p.code.service.impl;

import com.peanut.p2p.code.dao.ContractDao;
import com.peanut.p2p.code.model.entity.Contract;
import com.peanut.p2p.code.service.ContractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by my on 2015/3/18.
 */
@Service("contractService")
public class ContractServiceImpl implements ContractService{

    @Resource
    private ContractDao contractDao;
    @Override
    public List<Contract> queryAll() {
        return contractDao.findAll(Contract.class);
    }

    @Override
    public Contract queryByID(Integer id) {
        return contractDao.findById(Contract.class,id);
    }

    @Override
    public void doSave(Contract bank) {
        contractDao.save(bank);
    }

    @Override
    public void doUpdate(Contract bank) {
       contractDao.update(bank);
    }

    @Override
    public void doDelete(Integer id) {
       Contract bank = contractDao.findById(Contract.class,id);
        contractDao.delete(bank);
    }

    @Override
    public void doUpdate(Integer id) {
        contractDao.update(id);
    }
 /*   //上传图片
    @Override
    public void uploadImage( MultipartFile file,Contract bank) {
        // 保存相对路径到数据库 图片写入服务器
        if (file != null && !file.isEmpty()) {
            // 获取图片的文件名
            String fileName = file.getOriginalFilename();
            // 获取图片的扩展名
            String extensionName = fileName
                    .substring(fileName.lastIndexOf(".") + 1);
            // 新的图片文件名 = 获取时间戳+"."图片扩展名
            String newFileName = String.valueOf(System.currentTimeMillis())
                    + "." + extensionName;
            try {
                *//*上传到服务器上*//*
                InputStream is = (FileInputStream) file.getInputStream();
                OutputStream os = new FileOutputStream("E:/" + newFileName + fileName);
                int len = 0;
                byte[] b = new byte[is.available()];
                while ((len = is.read(b)) != -1) {
                    os.write(b, 0, len);
                    os.flush();
                }
                is.close();
                os.close();
                *//*得到字节流写入数据库中*//*
                byte[] bank_img = file.getBytes();
              //  bank.setContract_img(bank_img);
                *//*设置图片的url为上传服务器的url*//*
            //    bank.setImage_url("E:/" + newFileName + fileName);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }*/
}