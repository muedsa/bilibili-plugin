// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: bilibili/community/service/dm/v1/dm.proto
// Protobuf Java Version: 4.29.0

package com.bapis.bilibili.community.service.dm.v1;

public interface DmSegSDKReplyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:bilibili.community.service.dm.v1.DmSegSDKReply)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <pre>
   * 弹幕区是否关闭
   * </pre>
   *
   * <code>bool closed = 1;</code>
   * @return The closed.
   */
  boolean getClosed();

  /**
   * <pre>
   * elems 弹幕列表
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 2;</code>
   */
  java.util.List<com.bapis.bilibili.community.service.dm.v1.DanmakuElem> 
      getElemsList();
  /**
   * <pre>
   * elems 弹幕列表
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 2;</code>
   */
  com.bapis.bilibili.community.service.dm.v1.DanmakuElem getElems(int index);
  /**
   * <pre>
   * elems 弹幕列表
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 2;</code>
   */
  int getElemsCount();
}
