// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: bilibili/community/service/dm/v1/dm.proto
// Protobuf Java Version: 4.29.0

package com.bapis.bilibili.community.service.dm.v1;

public interface DmSegMobileReplyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:bilibili.community.service.dm.v1.DmSegMobileReply)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <pre>
   * elems 弹幕列表
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 1;</code>
   */
  java.util.List<com.bapis.bilibili.community.service.dm.v1.DanmakuElem> 
      getElemsList();
  /**
   * <pre>
   * elems 弹幕列表
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 1;</code>
   */
  com.bapis.bilibili.community.service.dm.v1.DanmakuElem getElems(int index);
  /**
   * <pre>
   * elems 弹幕列表
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.DanmakuElem elems = 1;</code>
   */
  int getElemsCount();

  /**
   * <pre>
   * state 弹幕区状态  0:打开 1:关闭弹幕区
   * </pre>
   *
   * <code>int32 state = 2;</code>
   * @return The state.
   */
  int getState();

  /**
   * <pre>
   * ai_flag ai打分
   * </pre>
   *
   * <code>.bilibili.community.service.dm.v1.DanmakuAIFlag ai_flag = 3;</code>
   * @return Whether the aiFlag field is set.
   */
  boolean hasAiFlag();
  /**
   * <pre>
   * ai_flag ai打分
   * </pre>
   *
   * <code>.bilibili.community.service.dm.v1.DanmakuAIFlag ai_flag = 3;</code>
   * @return The aiFlag.
   */
  com.bapis.bilibili.community.service.dm.v1.DanmakuAIFlag getAiFlag();
}