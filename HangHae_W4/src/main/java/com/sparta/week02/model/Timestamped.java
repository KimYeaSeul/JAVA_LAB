package com.sparta.week02.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


@MappedSuperclass // 상속했을 때, 컬럼으로 인식하게 합니다.
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor // 시간을 자동으로 반영하도록 설정
public abstract class Timestamped {
    
    @CreatedDate // 생성일
    private LocalDateTime createAt;
    
    @LastModifiedDate // 마지막 수정일
    private LocalDateTime modifiedAt;
}
