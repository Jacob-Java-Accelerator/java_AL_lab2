package com.structuralPattern.proxyPattern.networkProxy;

public class Main {

  public static void main(String[] args) {
    Request proxy = new ProxyNetworkRequest();
    System.out.println(proxy.request("http:www.api.com/api/v1/test"));
    System.out.println(proxy.request("http:www.api.com/api/v1/test"));
  }
}
