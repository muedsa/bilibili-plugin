// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: bilibili/community/service/dm/v1/dm.proto
// Protobuf Java Version: 4.29.0

package com.bapis.bilibili.community.service.dm.v1;

public interface DmViewReqOrBuilder extends
    // @@protoc_insertion_point(interface_extends:bilibili.community.service.dm.v1.DmViewReq)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <pre>
   * type=1--&gt; 稿件id  type=2 --&gt; 漫画ID
   * </pre>
   *
   * <code>int64 pid = 1;</code>
   * @return The pid.
   */
  long getPid();

  /**
   * <pre>
   * oid  type=1: 视频id
   * </pre>
   *
   * <code>int64 oid = 2;</code>
   * @return The oid.
   */
  long getOid();

  /**
   * <pre>
   * type 1:视频
   * </pre>
   *
   * <code>int32 type = 3;</code>
   * @return The type.
   */
  int getType();

  /**
   * <pre>
   * spmid 页面id
   * </pre>
   *
   * <code>string spmid = 4;</code>
   * @return The spmid.
   */
  java.lang.String getSpmid();
  /**
   * <pre>
   * spmid 页面id
   * </pre>
   *
   * <code>string spmid = 4;</code>
   * @return The bytes for spmid.
   */
  com.google.protobuf.ByteString
      getSpmidBytes();

  /**
   * <pre>
   * 是否冷启
   * </pre>
   *
   * <code>int32 is_hard_boot = 5;</code>
   * @return The isHardBoot.
   */
  int getIsHardBoot();
}
