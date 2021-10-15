package com.trkj.crmproject.vo.Indexes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactsSearchVo {
    private Integer pageNum;
    private Integer pageSize;
    private String keyword;
    private String contactCategory;
    private String contactsName;
}
