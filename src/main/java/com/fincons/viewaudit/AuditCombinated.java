package com.fincons.viewaudit;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_combined_view")
public class AuditCombinated {

    /*
    you need before to go to mySqlWorkbench and create query for view


	QUERY per VIEW PER DEMO FINALE (IMPLEMENTARE UN AUDIT E UN GRAFICO)


CREATE VIEW audit_combined_view AS
SELECT
    ROW_NUMBER() OVER (ORDER BY type, create_date) AS id,
    type,
    title_or_name,
    create_date,
    last_modified,
    created_by,
    last_modified_by
FROM (
    SELECT 'course' AS type,
           name AS title_or_name,
           create_date,
           last_modified,
           created_by,
           last_modified_by
    FROM courses
    UNION ALL
    SELECT 'quiz' AS type,
           title AS title_or_name,
           create_date,
           last_Modified,
           created_By,
           last_modified_by
    FROM quizzes
) AS combined_data;

     */
    @Id
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String type;

    @Column(name = "title_or_name",nullable = false)
    private String titleOrName;

    @CreatedDate
    @Column(
            nullable = false,
            updatable = false
    )
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModified;

    @CreatedBy
    @Column(
            nullable = false,
            updatable = false
    )
    private String createdBy;

    @LastModifiedBy
    @Column(insertable = false)
    private String lastModifiedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitleOrName() {
        return titleOrName;
    }

    public void setTitleOrName(String titleOrName) {
        this.titleOrName = titleOrName;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
}
