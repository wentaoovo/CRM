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
    //分页查询联系人列表信息
    @PostMapping("/select")
    public ResultVo select(@RequestBody ContactsSearchVo contactsSearchVo){
        PageInfo<IxContactsDetails> all = contactsDetailsService.selectAll(contactsSearchVo);
        return ResultVoUtil.success(all);
    }
    //查询所有客户
    @GetMapping("/selectname")
    public ResultVo selectOne(){
        List<Map> list = contactsDetailsService.selectByOne();
        return ResultVoUtil.success(list);
    }
    //新增联系人
    @PostMapping("/insert")
    public ResultVo save(@RequestBody IxContactsDetails ixContactsDetails) throws Exception{
        int insert = contactsDetailsService.insert(ixContactsDetails);
        return ResultVoUtil.success(insert);
    }
    //修改联系人
    @PutMapping("/updata")
    public ResultVo updata(@RequestBody IxContactsDetails ixContactsDetails){
        int i = contactsDetailsService.updateByPrimaryKeySelective(ixContactsDetails);
        return ResultVoUtil.success(i);
    }
    //根据id查询联系人
    @GetMapping("/selectByone/{id}")
    public ResultVo select1(@PathVariable("id")String id){
        IxContactsDetails ixContactsDetails = contactsDetailsService.selectByPrimaryKey(id);
        return ResultVoUtil.success(ixContactsDetails);
    }
    //根据id删除联系人
    @DeleteMapping("/delete/{id}")
    public ResultVo delete(@PathVariable("id")String id){
        int i = contactsDetailsService.deleteByPrimaryKey(id);
        return ResultVoUtil.success(i);
    }
    //联系人接口（订单）
    @GetMapping("/selectYomer/{id}")
    public ResultVo selectyomer(@PathVariable("id") String id){
        List<Map> strings = contactsDetailsService.selectYomer(id);
        return ResultVoUtil.success(strings);

    }

}
