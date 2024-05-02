package com.edson.springdesktop.domain.entity.order;

import com.edson.springdesktop.domain.entity.client.Client;
import com.edson.springdesktop.domain.entity.orderItem.OrderItem;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
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

  private Date invoiceDateTime;

  private Date recordDate;

  @Column(name = "naturezaOperacao")
  private String operationNature;

  @OneToMany(mappedBy = "order")
  private List<OrderItem> orderItems;

  @ManyToOne
  private Client client;

  private String driver;

  public Order() {}

  public Order(
    Long id,
    String noteNumber,
    String noteKey,
    String additionalInformation,
    Date invoiceDateTime,
    String operationNature,
    List<OrderItem> orderItems,
    Client client,
    String driver
  ) {
    this.id = id;
    this.noteNumber = noteNumber;
    this.noteKey = noteKey;
    this.additionalInformation = additionalInformation;
    this.invoiceDateTime = invoiceDateTime;
    this.operationNature = operationNature;
    this.orderItems = orderItems;
    this.client = client;
    this.driver = driver;
  }

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

 

  public String getOperationNature() {
    return operationNature;
  }

  public void setOperationNature(String operationNature) {
    this.operationNature = operationNature;
  }

  public String getDriver() {
    return driver;
  }

  public void setDriver(String driver) {
    this.driver = driver;
  }

  public Date getRecordDate() {
    return recordDate;
  }

  public void setRecordDate(Date recordDate) {
    this.recordDate = recordDate;
  }

  public Date getInvoiceDateTime() {
    return invoiceDateTime;
  }

  public void setInvoiceDateTime(Date invoiceDateTime) {
    this.invoiceDateTime = invoiceDateTime;
  }
}
