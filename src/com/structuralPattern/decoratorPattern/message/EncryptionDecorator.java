package com.structuralPattern.decoratorPattern.message;

public class EncryptionDecorator implements MessageDecorator {

  protected Message msg;

  public EncryptionDecorator(Message msg) {
    this.msg = msg;
  }

  @Override
  public void setContent(String str) {
    msg.setContent("Encrypted " + str);
  }

  @Override
  public String getContent() {
    return "Encrypted " + msg.getContent();
  }

  @Override
  public void send() {
    System.out.println(getContent());
  }

}
