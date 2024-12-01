// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: bilibili/community/service/dm/v1/dm.proto
// Protobuf Java Version: 4.29.0

package com.bapis.bilibili.community.service.dm.v1;

public interface VideoMaskOrBuilder extends
    // @@protoc_insertion_point(interface_extends:bilibili.community.service.dm.v1.VideoMask)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <pre>
   * 视频cid
   * </pre>
   *
   * <code>int64 cid = 1;</code>
   * @return The cid.
   */
  long getCid();

  /**
   * <pre>
   * 平台 0为网页端，1为移动端
   * </pre>
   *
   * <code>int32 plat = 2;</code>
   * @return The plat.
   */
  int getPlat();

  /**
   * <pre>
   * 视频帧率
   * </pre>
   *
   * <code>int32 fps = 3;</code>
   * @return The fps.
   */
  int getFps();

  /**
   * <pre>
   * 间隔时间
   * </pre>
   *
   * <code>int64 time = 4;</code>
   * @return The time.
   */
  long getTime();

  /**
   * <pre>
   * 弹幕蒙版地址链接
   * </pre>
   *
   * <code>string mask_url = 5;</code>
   * @return The maskUrl.
   */
  java.lang.String getMaskUrl();
  /**
   * <pre>
   * 弹幕蒙版地址链接
   * </pre>
   *
   * <code>string mask_url = 5;</code>
   * @return The bytes for maskUrl.
   */
  com.google.protobuf.ByteString
      getMaskUrlBytes();
}
