package com.aeroparker.db.entity_relation;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class CustomerSiteKey {
    private int customerId;
    private int siteId;

}
