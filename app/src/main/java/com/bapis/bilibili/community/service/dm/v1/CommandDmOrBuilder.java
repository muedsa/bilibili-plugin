// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: bilibili/community/service/dm/v1/dm.proto
// Protobuf Java Version: 4.29.0

package com.bapis.bilibili.community.service.dm.v1;

public interface CommandDmOrBuilder extends
    // @@protoc_insertion_point(interface_extends:bilibili.community.service.dm.v1.CommandDm)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <pre>
   * 弹幕id
   * </pre>
   *
   * <code>int64 id = 1;</code>
   * @return The id.
   */
  long getId();

  /**
   * <pre>
   * oid
   * </pre>
   *
   * <code>int64 oid = 2;</code>
   * @return The oid.
   */
  long getOid();

  /**
   * <pre>
   * mid
   * </pre>
   *
   * <code>int64 mid = 3;</code>
   * @return The mid.
   */
  long getMid();

  /**
   * <pre>
   * 弹幕指令
   * </pre>
   *
   * <code>string command = 4;</code>
   * @return The command.
   */
  java.lang.String getCommand();
  /**
   * <pre>
   * 弹幕指令
   * </pre>
   *
   * <code>string command = 4;</code>
   * @return The bytes for command.
   */
  com.google.protobuf.ByteString
      getCommandBytes();

  /**
   * <pre>
   * 弹幕内容
   * </pre>
   *
   * <code>string content = 5;</code>
   * @return The content.
   */
  java.lang.String getContent();
  /**
   * <pre>
   * 弹幕内容
   * </pre>
   *
   * <code>string content = 5;</code>
   * @return The bytes for content.
   */
  com.google.protobuf.ByteString
      getContentBytes();

  /**
   * <pre>
   * 弹幕位置
   * </pre>
   *
   * <code>int32 progress = 6;</code>
   * @return The progress.
   */
  int getProgress();

  /**
   * <pre>
   * 创建时间
   * </pre>
   *
   * <code>string ctime = 7;</code>
   * @return The ctime.
   */
  java.lang.String getCtime();
  /**
   * <pre>
   * 创建时间
   * </pre>
   *
   * <code>string ctime = 7;</code>
   * @return The bytes for ctime.
   */
  com.google.protobuf.ByteString
      getCtimeBytes();

  /**
   * <pre>
   * 修改时间
   * </pre>
   *
   * <code>string mtime = 8;</code>
   * @return The mtime.
   */
  java.lang.String getMtime();
  /**
   * <pre>
   * 修改时间
   * </pre>
   *
   * <code>string mtime = 8;</code>
   * @return The bytes for mtime.
   */
  com.google.protobuf.ByteString
      getMtimeBytes();

  /**
   * <pre>
   * extra
   * </pre>
   *
   * <code>string extra = 9;</code>
   * @return The extra.
   */
  java.lang.String getExtra();
  /**
   * <pre>
   * extra
   * </pre>
   *
   * <code>string extra = 9;</code>
   * @return The bytes for extra.
   */
  com.google.protobuf.ByteString
      getExtraBytes();

  /**
   * <pre>
   * id string类型
   * </pre>
   *
   * <code>string idstr = 10;</code>
   * @return The idstr.
   */
  java.lang.String getIdstr();
  /**
   * <pre>
   * id string类型
   * </pre>
   *
   * <code>string idstr = 10;</code>
   * @return The bytes for idstr.
   */
  com.google.protobuf.ByteString
      getIdstrBytes();
}