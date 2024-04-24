package com.edson.springdesktop.domain.model;

import com.edson.springdesktop.domain.model.orderItem.OrderItem;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String noteNumber;

  private String noteKey;

  private String additionalInformation;

  private Date issueDate;

  @Column(name = "naturezaOperacao")
  private String operationNature;

  @OneToMany(mappedBy = "order")
  private List<OrderItem> orderItems;

  @ManyToOne
  private Client client;

  public Order() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<OrderItem> getOrderItems() {
    return orderItems;
  }

  public void setOrderItems(List<OrderItem> orderItems) {
    this.orderItems = orderItems;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public String getNoteNumber() {
    return noteNumber;
  }

  public void setNoteNumber(String noteNumber) {
    this.noteNumber = noteNumber;
  }

  public String getNoteKey() {
    return noteKey;
  }

  public void setNoteKey(String noteKey) {
    this.noteKey = noteKey;
  }

  public String getAdditionalInformation() {
    return additionalInformation;
  }

  public void setAdditionalInformation(String additionalInformation) {
    this.additionalInformation = additionalInformation;
  }

  public Date getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(Date issueDate) {
    this.issueDate = issueDate;
  }

  public String getOperationNature() {
    return operationNature;
  }

  public void setOperationNature(String operationNature) {
    this.operationNature = operationNature;
  }
  
}
