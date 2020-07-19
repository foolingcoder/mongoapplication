package com.mns.mongoapplication.common;

import java.time.Instant;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

/**
 *
 * @author ganesh
 */
@Data
public abstract class AuditMongo {
    @CreatedBy
    private String user = "Ganesh";

    @CreatedDate
    private Instant createdDate;

    @LastModifiedBy
    private String lastModifiedUser;

    @LastModifiedDate
    private Instant lastModifiedDate;
}
