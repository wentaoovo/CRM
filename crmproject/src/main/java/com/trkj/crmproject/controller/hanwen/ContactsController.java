package com.trkj.crmproject.controller.hanwen;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.hanwen.IxContactsDetails;
import com.trkj.crmproject.entity.hanwen.IxCustomerDetails;
import com.trkj.crmproject.service.hanwen.ContactsDetailsService;
import com.trkj.crmproject.util.ResultVoUtil;
import com.trkj.crmproject.vo.Indexes.ContactsSearchVo;
import com.trkj.crmproject.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/three")
public class ContactsController {
    @Autowired
    private ContactsDetailsService contactsDetailsService;
    @PostMapping("/select")
    public ResultVo select(@RequestBody ContactsSearchVo contactsSearchVo){
        PageInfo<IxContactsDetails> all = contactsDetailsService.selectAll(contactsSearchVo);
        return ResultVoUtil.success(all);
    }
    @GetMapping("/selectname")
    public ResultVo selectOne(){
        List<Map> list = contactsDetailsService.selectByOne();
        return ResultVoUtil.success(list);
    }
    @PostMapping("/insert")
    public ResultVo save(@RequestBody IxContactsDetails ixContactsDetails){
        int insert = contactsDetailsService.insert(ixContactsDetails);
        return ResultVoUtil.success(insert);
    }
    @PutMapping("/updata")
    public ResultVo updata(@RequestBody IxContactsDetails ixContactsDetails){
        int i = contactsDetailsService.updateByPrimaryKeySelective(ixContactsDetails);
        return ResultVoUtil.success(i);
    }
    @GetMapping("/selectByone/{id}")
    public ResultVo select1(@PathVariable("id")String id){
        IxContactsDetails ixContactsDetails = contactsDetailsService.selectByPrimaryKey(id);
        return ResultVoUtil.success(ixContactsDetails);
    }
    @DeleteMapping("/delete/{id}")
    public ResultVo delete(@PathVariable("id")String id){
        int i = contactsDetailsService.deleteByPrimaryKey(id);
        return ResultVoUtil.success(i);
    }
    //联系人接口（订单）
    @GetMapping("/selectYomer")
    public ResultVo selectyomer(){
        List<String> strings = contactsDetailsService.selectYomer();
        return ResultVoUtil.success(strings);

    }

}
