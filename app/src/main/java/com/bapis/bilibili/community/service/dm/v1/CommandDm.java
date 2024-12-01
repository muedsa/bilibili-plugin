// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: bilibili/community/service/dm/v1/dm.proto
// Protobuf Java Version: 4.29.0

package com.bapis.bilibili.community.service.dm.v1;

/**
 * <pre>
 * 指令弹幕
 * </pre>
 *
 * Protobuf type {@code bilibili.community.service.dm.v1.CommandDm}
 */
public  final class CommandDm extends
    com.google.protobuf.GeneratedMessageLite<
        CommandDm, CommandDm.Builder> implements
    // @@protoc_insertion_point(message_implements:bilibili.community.service.dm.v1.CommandDm)
    CommandDmOrBuilder {
  private CommandDm() {
    command_ = "";
    content_ = "";
    ctime_ = "";
    mtime_ = "";
    extra_ = "";
    idstr_ = "";
  }
  public static final int ID_FIELD_NUMBER = 1;
  private long id_;
  /**
   * <pre>
   * 弹幕id
   * </pre>
   *
   * <code>int64 id = 1;</code>
   * @return The id.
   */
  @java.lang.Override
  public long getId() {
    return id_;
  }
  /**
   * <pre>
   * 弹幕id
   * </pre>
   *
   * <code>int64 id = 1;</code>
   * @param value The id to set.
   */
  private void setId(long value) {
    
    id_ = value;
  }
  /**
   * <pre>
   * 弹幕id
   * </pre>
   *
   * <code>int64 id = 1;</code>
   */
  private void clearId() {

    id_ = 0L;
  }

  public static final int OID_FIELD_NUMBER = 2;
  private long oid_;
  /**
   * <pre>
   * oid
   * </pre>
   *
   * <code>int64 oid = 2;</code>
   * @return The oid.
   */
  @java.lang.Override
  public long getOid() {
    return oid_;
  }
  /**
   * <pre>
   * oid
   * </pre>
   *
   * <code>int64 oid = 2;</code>
   * @param value The oid to set.
   */
  private void setOid(long value) {
    
    oid_ = value;
  }
  /**
   * <pre>
   * oid
   * </pre>
   *
   * <code>int64 oid = 2;</code>
   */
  private void clearOid() {

    oid_ = 0L;
  }

  public static final int MID_FIELD_NUMBER = 3;
  private long mid_;
  /**
   * <pre>
   * mid
   * </pre>
   *
   * <code>int64 mid = 3;</code>
   * @return The mid.
   */
  @java.lang.Override
  public long getMid() {
    return mid_;
  }
  /**
   * <pre>
   * mid
   * </pre>
   *
   * <code>int64 mid = 3;</code>
   * @param value The mid to set.
   */
  private void setMid(long value) {
    
    mid_ = value;
  }
  /**
   * <pre>
   * mid
   * </pre>
   *
   * <code>int64 mid = 3;</code>
   */
  private void clearMid() {

    mid_ = 0L;
  }

  public static final int COMMAND_FIELD_NUMBER = 4;
  private java.lang.String command_;
  /**
   * <pre>
   * 弹幕指令
   * </pre>
   *
   * <code>string command = 4;</code>
   * @return The command.
   */
  @java.lang.Override
  public java.lang.String getCommand() {
    return command_;
  }
  /**
   * <pre>
   * 弹幕指令
   * </pre>
   *
   * <code>string command = 4;</code>
   * @return The bytes for command.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getCommandBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(command_);
  }
  /**
   * <pre>
   * 弹幕指令
   * </pre>
   *
   * <code>string command = 4;</code>
   * @param value The command to set.
   */
  @java.lang.SuppressWarnings("ReturnValueIgnored")
  private void setCommand(
      java.lang.String value) {
    value.getClass();  // minimal bytecode null check

    command_ = value;
  }
  /**
   * <pre>
   * 弹幕指令
   * </pre>
   *
   * <code>string command = 4;</code>
   */
  private void clearCommand() {

    command_ = getDefaultInstance().getCommand();
  }
  /**
   * <pre>
   * 弹幕指令
   * </pre>
   *
   * <code>string command = 4;</code>
   * @param value The bytes for command to set.
   */
  private void setCommandBytes(
      com.google.protobuf.ByteString value) {
    checkByteStringIsUtf8(value);
    command_ = value.toStringUtf8();

  }

  public static final int CONTENT_FIELD_NUMBER = 5;
  private java.lang.String content_;
  /**
   * <pre>
   * 弹幕内容
   * </pre>
   *
   * <code>string content = 5;</code>
   * @return The content.
   */
  @java.lang.Override
  public java.lang.String getContent() {
    return content_;
  }
  /**
   * <pre>
   * 弹幕内容
   * </pre>
   *
   * <code>string content = 5;</code>
   * @return The bytes for content.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getContentBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(content_);
  }
  /**
   * <pre>
   * 弹幕内容
   * </pre>
   *
   * <code>string content = 5;</code>
   * @param value The content to set.
   */
  @java.lang.SuppressWarnings("ReturnValueIgnored")
  private void setContent(
      java.lang.String value) {
    value.getClass();  // minimal bytecode null check

    content_ = value;
  }
  /**
   * <pre>
   * 弹幕内容
   * </pre>
   *
   * <code>string content = 5;</code>
   */
  private void clearContent() {

    content_ = getDefaultInstance().getContent();
  }
  /**
   * <pre>
   * 弹幕内容
   * </pre>
   *
   * <code>string content = 5;</code>
   * @param value The bytes for content to set.
   */
  private void setContentBytes(
      com.google.protobuf.ByteString value) {
    checkByteStringIsUtf8(value);
    content_ = value.toStringUtf8();

  }

  public static final int PROGRESS_FIELD_NUMBER = 6;
  private int progress_;
  /**
   * <pre>
   * 弹幕位置
   * </pre>
   *
   * <code>int32 progress = 6;</code>
   * @return The progress.
   */
  @java.lang.Override
  public int getProgress() {
    return progress_;
  }
  /**
   * <pre>
   * 弹幕位置
   * </pre>
   *
   * <code>int32 progress = 6;</code>
   * @param value The progress to set.
   */
  private void setProgress(int value) {
    
    progress_ = value;
  }
  /**
   * <pre>
   * 弹幕位置
   * </pre>
   *
   * <code>int32 progress = 6;</code>
   */
  private void clearProgress() {

    progress_ = 0;
  }

  public static final int CTIME_FIELD_NUMBER = 7;
  private java.lang.String ctime_;
  /**
   * <pre>
   * 创建时间
   * </pre>
   *
   * <code>string ctime = 7;</code>
   * @return The ctime.
   */
  @java.lang.Override
  public java.lang.String getCtime() {
    return ctime_;
  }
  /**
   * <pre>
   * 创建时间
   * </pre>
   *
   * <code>string ctime = 7;</code>
   * @return The bytes for ctime.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getCtimeBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(ctime_);
  }
  /**
   * <pre>
   * 创建时间
   * </pre>
   *
   * <code>string ctime = 7;</code>
   * @param value The ctime to set.
   */
  @java.lang.SuppressWarnings("ReturnValueIgnored")
  private void setCtime(
      java.lang.String value) {
    value.getClass();  // minimal bytecode null check

    ctime_ = value;
  }
  /**
   * <pre>
   * 创建时间
   * </pre>
   *
   * <code>string ctime = 7;</code>
   */
  private void clearCtime() {

    ctime_ = getDefaultInstance().getCtime();
  }
  /**
   * <pre>
   * 创建时间
   * </pre>
   *
   * <code>string ctime = 7;</code>
   * @param value The bytes for ctime to set.
   */
  private void setCtimeBytes(
      com.google.protobuf.ByteString value) {
    checkByteStringIsUtf8(value);
    ctime_ = value.toStringUtf8();

  }

  public static final int MTIME_FIELD_NUMBER = 8;
  private java.lang.String mtime_;
  /**
   * <pre>
   * 修改时间
   * </pre>
   *
   * <code>string mtime = 8;</code>
   * @return The mtime.
   */
  @java.lang.Override
  public java.lang.String getMtime() {
    return mtime_;
  }
  /**
   * <pre>
   * 修改时间
   * </pre>
   *
   * <code>string mtime = 8;</code>
   * @return The bytes for mtime.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getMtimeBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(mtime_);
  }
  /**
   * <pre>
   * 修改时间
   * </pre>
   *
   * <code>string mtime = 8;</code>
   * @param value The mtime to set.
   */
  @java.lang.SuppressWarnings("ReturnValueIgnored")
  private void setMtime(
      java.lang.String value) {
    value.getClass();  // minimal bytecode null check

    mtime_ = value;
  }
  /**
   * <pre>
   * 修改时间
   * </pre>
   *
   * <code>string mtime = 8;</code>
   */
  private void clearMtime() {

    mtime_ = getDefaultInstance().getMtime();
  }
  /**
   * <pre>
   * 修改时间
   * </pre>
   *
   * <code>string mtime = 8;</code>
   * @param value The bytes for mtime to set.
   */
  private void setMtimeBytes(
      com.google.protobuf.ByteString value) {
    checkByteStringIsUtf8(value);
    mtime_ = value.toStringUtf8();

  }

  public static final int EXTRA_FIELD_NUMBER = 9;
  private java.lang.String extra_;
  /**
   * <pre>
   * extra
   * </pre>
   *
   * <code>string extra = 9;</code>
   * @return The extra.
   */
  @java.lang.Override
  public java.lang.String getExtra() {
    return extra_;
  }
  /**
   * <pre>
   * extra
   * </pre>
   *
   * <code>string extra = 9;</code>
   * @return The bytes for extra.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getExtraBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(extra_);
  }
  /**
   * <pre>
   * extra
   * </pre>
   *
   * <code>string extra = 9;</code>
   * @param value The extra to set.
   */
  @java.lang.SuppressWarnings("ReturnValueIgnored")
  private void setExtra(
      java.lang.String value) {
    value.getClass();  // minimal bytecode null check

    extra_ = value;
  }
  /**
   * <pre>
   * extra
   * </pre>
   *
   * <code>string extra = 9;</code>
   */
  private void clearExtra() {

    extra_ = getDefaultInstance().getExtra();
  }
  /**
   * <pre>
   * extra
   * </pre>
   *
   * <code>string extra = 9;</code>
   * @param value The bytes for extra to set.
   */
  private void setExtraBytes(
      com.google.protobuf.ByteString value) {
    checkByteStringIsUtf8(value);
    extra_ = value.toStringUtf8();

  }

  public static final int IDSTR_FIELD_NUMBER = 10;
  private java.lang.String idstr_;
  /**
   * <pre>
   * id string类型
   * </pre>
   *
   * <code>string idstr = 10;</code>
   * @return The idstr.
   */
  @java.lang.Override
  public java.lang.String getIdstr() {
    return idstr_;
  }
  /**
   * <pre>
   * id string类型
   * </pre>
   *
   * <code>string idstr = 10;</code>
   * @return The bytes for idstr.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getIdstrBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(idstr_);
  }
  /**
   * <pre>
   * id string类型
   * </pre>
   *
   * <code>string idstr = 10;</code>
   * @param value The idstr to set.
   */
  @java.lang.SuppressWarnings("ReturnValueIgnored")
  private void setIdstr(
      java.lang.String value) {
    value.getClass();  // minimal bytecode null check

    idstr_ = value;
  }
  /**
   * <pre>
   * id string类型
   * </pre>
   *
   * <code>string idstr = 10;</code>
   */
  private void clearIdstr() {

    idstr_ = getDefaultInstance().getIdstr();
  }
  /**
   * <pre>
   * id string类型
   * </pre>
   *
   * <code>string idstr = 10;</code>
   * @param value The bytes for idstr to set.
   */
  private void setIdstrBytes(
      com.google.protobuf.ByteString value) {
    checkByteStringIsUtf8(value);
    idstr_ = value.toStringUtf8();

  }

  public static com.bapis.bilibili.community.service.dm.v1.CommandDm parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.CommandDm parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.CommandDm parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.CommandDm parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.CommandDm parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.CommandDm parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.CommandDm parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.bapis.bilibili.community.service.dm.v1.CommandDm parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static com.bapis.bilibili.community.service.dm.v1.CommandDm parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }

  public static com.bapis.bilibili.community.service.dm.v1.CommandDm parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.CommandDm parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.bapis.bilibili.community.service.dm.v1.CommandDm parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return (Builder) DEFAULT_INSTANCE.createBuilder();
  }
  public static Builder newBuilder(com.bapis.bilibili.community.service.dm.v1.CommandDm prototype) {
    return DEFAULT_INSTANCE.createBuilder(prototype);
  }

  /**
   * <pre>
   * 指令弹幕
   * </pre>
   *
   * Protobuf type {@code bilibili.community.service.dm.v1.CommandDm}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        com.bapis.bilibili.community.service.dm.v1.CommandDm, Builder> implements
      // @@protoc_insertion_point(builder_implements:bilibili.community.service.dm.v1.CommandDm)
      com.bapis.bilibili.community.service.dm.v1.CommandDmOrBuilder {
    // Construct using com.bapis.bilibili.community.service.dm.v1.CommandDm.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <pre>
     * 弹幕id
     * </pre>
     *
     * <code>int64 id = 1;</code>
     * @return The id.
     */
    @java.lang.Override
    public long getId() {
      return instance.getId();
    }
    /**
     * <pre>
     * 弹幕id
     * </pre>
     *
     * <code>int64 id = 1;</code>
     * @param value The id to set.
     * @return This builder for chaining.
     */
    public Builder setId(long value) {
      copyOnWrite();
      instance.setId(value);
      return this;
    }
    /**
     * <pre>
     * 弹幕id
     * </pre>
     *
     * <code>int64 id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearId() {
      copyOnWrite();
      instance.clearId();
      return this;
    }

    /**
     * <pre>
     * oid
     * </pre>
     *
     * <code>int64 oid = 2;</code>
     * @return The oid.
     */
    @java.lang.Override
    public long getOid() {
      return instance.getOid();
    }
    /**
     * <pre>
     * oid
     * </pre>
     *
     * <code>int64 oid = 2;</code>
     * @param value The oid to set.
     * @return This builder for chaining.
     */
    public Builder setOid(long value) {
      copyOnWrite();
      instance.setOid(value);
      return this;
    }
    /**
     * <pre>
     * oid
     * </pre>
     *
     * <code>int64 oid = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearOid() {
      copyOnWrite();
      instance.clearOid();
      return this;
    }

    /**
     * <pre>
     * mid
     * </pre>
     *
     * <code>int64 mid = 3;</code>
     * @return The mid.
     */
    @java.lang.Override
    public long getMid() {
      return instance.getMid();
    }
    /**
     * <pre>
     * mid
     * </pre>
     *
     * <code>int64 mid = 3;</code>
     * @param value The mid to set.
     * @return This builder for chaining.
     */
    public Builder setMid(long value) {
      copyOnWrite();
      instance.setMid(value);
      return this;
    }
    /**
     * <pre>
     * mid
     * </pre>
     *
     * <code>int64 mid = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearMid() {
      copyOnWrite();
      instance.clearMid();
      return this;
    }

    /**
     * <pre>
     * 弹幕指令
     * </pre>
     *
     * <code>string command = 4;</code>
     * @return The command.
     */
    @java.lang.Override
    public java.lang.String getCommand() {
      return instance.getCommand();
    }
    /**
     * <pre>
     * 弹幕指令
     * </pre>
     *
     * <code>string command = 4;</code>
     * @return The bytes for command.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getCommandBytes() {
      return instance.getCommandBytes();
    }
    /**
     * <pre>
     * 弹幕指令
     * </pre>
     *
     * <code>string command = 4;</code>
     * @param value The command to set.
     * @return This builder for chaining.
     */
    public Builder setCommand(
        java.lang.String value) {
      copyOnWrite();
      instance.setCommand(value);
      return this;
    }
    /**
     * <pre>
     * 弹幕指令
     * </pre>
     *
     * <code>string command = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearCommand() {
      copyOnWrite();
      instance.clearCommand();
      return this;
    }
    /**
     * <pre>
     * 弹幕指令
     * </pre>
     *
     * <code>string command = 4;</code>
     * @param value The bytes for command to set.
     * @return This builder for chaining.
     */
    public Builder setCommandBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setCommandBytes(value);
      return this;
    }

    /**
     * <pre>
     * 弹幕内容
     * </pre>
     *
     * <code>string content = 5;</code>
     * @return The content.
     */
    @java.lang.Override
    public java.lang.String getContent() {
      return instance.getContent();
    }
    /**
     * <pre>
     * 弹幕内容
     * </pre>
     *
     * <code>string content = 5;</code>
     * @return The bytes for content.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getContentBytes() {
      return instance.getContentBytes();
    }
    /**
     * <pre>
     * 弹幕内容
     * </pre>
     *
     * <code>string content = 5;</code>
     * @param value The content to set.
     * @return This builder for chaining.
     */
    public Builder setContent(
        java.lang.String value) {
      copyOnWrite();
      instance.setContent(value);
      return this;
    }
    /**
     * <pre>
     * 弹幕内容
     * </pre>
     *
     * <code>string content = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearContent() {
      copyOnWrite();
      instance.clearContent();
      return this;
    }
    /**
     * <pre>
     * 弹幕内容
     * </pre>
     *
     * <code>string content = 5;</code>
     * @param value The bytes for content to set.
     * @return This builder for chaining.
     */
    public Builder setContentBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setContentBytes(value);
      return this;
    }

    /**
     * <pre>
     * 弹幕位置
     * </pre>
     *
     * <code>int32 progress = 6;</code>
     * @return The progress.
     */
    @java.lang.Override
    public int getProgress() {
      return instance.getProgress();
    }
    /**
     * <pre>
     * 弹幕位置
     * </pre>
     *
     * <code>int32 progress = 6;</code>
     * @param value The progress to set.
     * @return This builder for chaining.
     */
    public Builder setProgress(int value) {
      copyOnWrite();
      instance.setProgress(value);
      return this;
    }
    /**
     * <pre>
     * 弹幕位置
     * </pre>
     *
     * <code>int32 progress = 6;</code>
     * @return This builder for chaining.
     */
    public Builder clearProgress() {
      copyOnWrite();
      instance.clearProgress();
      return this;
    }

    /**
     * <pre>
     * 创建时间
     * </pre>
     *
     * <code>string ctime = 7;</code>
     * @return The ctime.
     */
    @java.lang.Override
    public java.lang.String getCtime() {
      return instance.getCtime();
    }
    /**
     * <pre>
     * 创建时间
     * </pre>
     *
     * <code>string ctime = 7;</code>
     * @return The bytes for ctime.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getCtimeBytes() {
      return instance.getCtimeBytes();
    }
    /**
     * <pre>
     * 创建时间
     * </pre>
     *
     * <code>string ctime = 7;</code>
     * @param value The ctime to set.
     * @return This builder for chaining.
     */
    public Builder setCtime(
        java.lang.String value) {
      copyOnWrite();
      instance.setCtime(value);
      return this;
    }
    /**
     * <pre>
     * 创建时间
     * </pre>
     *
     * <code>string ctime = 7;</code>
     * @return This builder for chaining.
     */
    public Builder clearCtime() {
      copyOnWrite();
      instance.clearCtime();
      return this;
    }
    /**
     * <pre>
     * 创建时间
     * </pre>
     *
     * <code>string ctime = 7;</code>
     * @param value The bytes for ctime to set.
     * @return This builder for chaining.
     */
    public Builder setCtimeBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setCtimeBytes(value);
      return this;
    }

    /**
     * <pre>
     * 修改时间
     * </pre>
     *
     * <code>string mtime = 8;</code>
     * @return The mtime.
     */
    @java.lang.Override
    public java.lang.String getMtime() {
      return instance.getMtime();
    }
    /**
     * <pre>
     * 修改时间
     * </pre>
     *
     * <code>string mtime = 8;</code>
     * @return The bytes for mtime.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getMtimeBytes() {
      return instance.getMtimeBytes();
    }
    /**
     * <pre>
     * 修改时间
     * </pre>
     *
     * <code>string mtime = 8;</code>
     * @param value The mtime to set.
     * @return This builder for chaining.
     */
    public Builder setMtime(
        java.lang.String value) {
      copyOnWrite();
      instance.setMtime(value);
      return this;
    }
    /**
     * <pre>
     * 修改时间
     * </pre>
     *
     * <code>string mtime = 8;</code>
     * @return This builder for chaining.
     */
    public Builder clearMtime() {
      copyOnWrite();
      instance.clearMtime();
      return this;
    }
    /**
     * <pre>
     * 修改时间
     * </pre>
     *
     * <code>string mtime = 8;</code>
     * @param value The bytes for mtime to set.
     * @return This builder for chaining.
     */
    public Builder setMtimeBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setMtimeBytes(value);
      return this;
    }

    /**
     * <pre>
     * extra
     * </pre>
     *
     * <code>string extra = 9;</code>
     * @return The extra.
     */
    @java.lang.Override
    public java.lang.String getExtra() {
      return instance.getExtra();
    }
    /**
     * <pre>
     * extra
     * </pre>
     *
     * <code>string extra = 9;</code>
     * @return The bytes for extra.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getExtraBytes() {
      return instance.getExtraBytes();
    }
    /**
     * <pre>
     * extra
     * </pre>
     *
     * <code>string extra = 9;</code>
     * @param value The extra to set.
     * @return This builder for chaining.
     */
    public Builder setExtra(
        java.lang.String value) {
      copyOnWrite();
      instance.setExtra(value);
      return this;
    }
    /**
     * <pre>
     * extra
     * </pre>
     *
     * <code>string extra = 9;</code>
     * @return This builder for chaining.
     */
    public Builder clearExtra() {
      copyOnWrite();
      instance.clearExtra();
      return this;
    }
    /**
     * <pre>
     * extra
     * </pre>
     *
     * <code>string extra = 9;</code>
     * @param value The bytes for extra to set.
     * @return This builder for chaining.
     */
    public Builder setExtraBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setExtraBytes(value);
      return this;
    }

    /**
     * <pre>
     * id string类型
     * </pre>
     *
     * <code>string idstr = 10;</code>
     * @return The idstr.
     */
    @java.lang.Override
    public java.lang.String getIdstr() {
      return instance.getIdstr();
    }
    /**
     * <pre>
     * id string类型
     * </pre>
     *
     * <code>string idstr = 10;</code>
     * @return The bytes for idstr.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getIdstrBytes() {
      return instance.getIdstrBytes();
    }
    /**
     * <pre>
     * id string类型
     * </pre>
     *
     * <code>string idstr = 10;</code>
     * @param value The idstr to set.
     * @return This builder for chaining.
     */
    public Builder setIdstr(
        java.lang.String value) {
      copyOnWrite();
      instance.setIdstr(value);
      return this;
    }
    /**
     * <pre>
     * id string类型
     * </pre>
     *
     * <code>string idstr = 10;</code>
     * @return This builder for chaining.
     */
    public Builder clearIdstr() {
      copyOnWrite();
      instance.clearIdstr();
      return this;
    }
    /**
     * <pre>
     * id string类型
     * </pre>
     *
     * <code>string idstr = 10;</code>
     * @param value The bytes for idstr to set.
     * @return This builder for chaining.
     */
    public Builder setIdstrBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setIdstrBytes(value);
      return this;
    }

    // @@protoc_insertion_point(builder_scope:bilibili.community.service.dm.v1.CommandDm)
  }
  @java.lang.Override
  @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
  protected final java.lang.Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      java.lang.Object arg0, java.lang.Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new com.bapis.bilibili.community.service.dm.v1.CommandDm();
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case BUILD_MESSAGE_INFO: {
          java.lang.Object[] objects = new java.lang.Object[] {
            "id_",
            "oid_",
            "mid_",
            "command_",
            "content_",
            "progress_",
            "ctime_",
            "mtime_",
            "extra_",
            "idstr_",
          };
          java.lang.String info =
              "\u0000\n\u0000\u0000\u0001\n\n\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003\u0002" +
              "\u0004\u0208\u0005\u0208\u0006\u0004\u0007\u0208\b\u0208\t\u0208\n\u0208";
          return newMessageInfo(DEFAULT_INSTANCE, info, objects);
      }
      // fall through
      case GET_DEFAULT_INSTANCE: {
        return DEFAULT_INSTANCE;
      }
      case GET_PARSER: {
        com.google.protobuf.Parser<com.bapis.bilibili.community.service.dm.v1.CommandDm> parser = PARSER;
        if (parser == null) {
          synchronized (com.bapis.bilibili.community.service.dm.v1.CommandDm.class) {
            parser = PARSER;
            if (parser == null) {
              parser =
                  new DefaultInstanceBasedParser<com.bapis.bilibili.community.service.dm.v1.CommandDm>(
                      DEFAULT_INSTANCE);
              PARSER = parser;
            }
          }
        }
        return parser;
    }
    case GET_MEMOIZED_IS_INITIALIZED: {
      return (byte) 1;
    }
    case SET_MEMOIZED_IS_INITIALIZED: {
      return null;
    }
    }
    throw new UnsupportedOperationException();
  }


  // @@protoc_insertion_point(class_scope:bilibili.community.service.dm.v1.CommandDm)
  private static final com.bapis.bilibili.community.service.dm.v1.CommandDm DEFAULT_INSTANCE;
  static {
    CommandDm defaultInstance = new CommandDm();
    // New instances are implicitly immutable so no need to make
    // immutable.
    DEFAULT_INSTANCE = defaultInstance;
    com.google.protobuf.GeneratedMessageLite.registerDefaultInstance(
      CommandDm.class, defaultInstance);
  }

  public static com.bapis.bilibili.community.service.dm.v1.CommandDm getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<CommandDm> PARSER;

  public static com.google.protobuf.Parser<CommandDm> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

