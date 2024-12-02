// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: bilibili/community/service/dm/v1/dm.proto
// Protobuf Java Version: 4.29.0

package com.bapis.bilibili.community.service.dm.v1;

public interface DmSegSDKReqOrBuilder extends
    // @@protoc_insertion_point(interface_extends:bilibili.community.service.dm.v1.DmSegSDKReq)
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
   * oid 视频id
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
   * segment_index 分段下标
   * </pre>
   *
   * <code>int64 segment_index = 4;</code>
   * @return The segmentIndex.
   */
  long getSegmentIndex();
}
