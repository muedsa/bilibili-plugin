// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: bilibili/community/service/dm/v1/dm.proto
// Protobuf Java Version: 4.29.0

package com.bapis.bilibili.community.service.dm.v1;

/**
 * Protobuf type {@code bilibili.community.service.dm.v1.DmExpoReportReq}
 */
public  final class DmExpoReportReq extends
    com.google.protobuf.GeneratedMessageLite<
        DmExpoReportReq, DmExpoReportReq.Builder> implements
    // @@protoc_insertion_point(message_implements:bilibili.community.service.dm.v1.DmExpoReportReq)
    DmExpoReportReqOrBuilder {
  private DmExpoReportReq() {
    sessionId_ = "";
    dmids_ = com.google.protobuf.ByteString.EMPTY;
    spmid_ = "";
  }
  public static final int SESSION_ID_FIELD_NUMBER = 1;
  private java.lang.String sessionId_;
  /**
   * <pre>
   * session id
   * </pre>
   *
   * <code>string session_id = 1;</code>
   * @return The sessionId.
   */
  @java.lang.Override
  public java.lang.String getSessionId() {
    return sessionId_;
  }
  /**
   * <pre>
   * session id
   * </pre>
   *
   * <code>string session_id = 1;</code>
   * @return The bytes for sessionId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getSessionIdBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(sessionId_);
  }
  /**
   * <pre>
   * session id
   * </pre>
   *
   * <code>string session_id = 1;</code>
   * @param value The sessionId to set.
   */
  @java.lang.SuppressWarnings("ReturnValueIgnored")
  private void setSessionId(
      java.lang.String value) {
    value.getClass();  // minimal bytecode null check

    sessionId_ = value;
  }
  /**
   * <pre>
   * session id
   * </pre>
   *
   * <code>string session_id = 1;</code>
   */
  private void clearSessionId() {

    sessionId_ = getDefaultInstance().getSessionId();
  }
  /**
   * <pre>
   * session id
   * </pre>
   *
   * <code>string session_id = 1;</code>
   * @param value The bytes for sessionId to set.
   */
  private void setSessionIdBytes(
      com.google.protobuf.ByteString value) {
    checkByteStringIsUtf8(value);
    sessionId_ = value.toStringUtf8();

  }

  public static final int OID_FIELD_NUMBER = 2;
  private long oid_;
  /**
   * <pre>
   * oid 视频id
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
   * oid 视频id
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
   * oid 视频id
   * </pre>
   *
   * <code>int64 oid = 2;</code>
   */
  private void clearOid() {

    oid_ = 0L;
  }

  public static final int DMIDS_FIELD_NUMBER = 3;
  private com.google.protobuf.ByteString dmids_;
  /**
   * <pre>
   * gzip dmid, 逗号分隔
   * </pre>
   *
   * <code>bytes dmids = 3;</code>
   * @return The dmids.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getDmids() {
    return dmids_;
  }
  /**
   * <pre>
   * gzip dmid, 逗号分隔
   * </pre>
   *
   * <code>bytes dmids = 3;</code>
   * @param value The dmids to set.
   */
  private void setDmids(com.google.protobuf.ByteString value) {
    java.lang.Class<?> valueClass = value.getClass();
  
    dmids_ = value;
  }
  /**
   * <pre>
   * gzip dmid, 逗号分隔
   * </pre>
   *
   * <code>bytes dmids = 3;</code>
   */
  private void clearDmids() {

    dmids_ = getDefaultInstance().getDmids();
  }

  public static final int SPMID_FIELD_NUMBER = 4;
  private java.lang.String spmid_;
  /**
   * <pre>
   * spmid 页面id
   * </pre>
   *
   * <code>string spmid = 4;</code>
   * @return The spmid.
   */
  @java.lang.Override
  public java.lang.String getSpmid() {
    return spmid_;
  }
  /**
   * <pre>
   * spmid 页面id
   * </pre>
   *
   * <code>string spmid = 4;</code>
   * @return The bytes for spmid.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getSpmidBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(spmid_);
  }
  /**
   * <pre>
   * spmid 页面id
   * </pre>
   *
   * <code>string spmid = 4;</code>
   * @param value The spmid to set.
   */
  @java.lang.SuppressWarnings("ReturnValueIgnored")
  private void setSpmid(
      java.lang.String value) {
    value.getClass();  // minimal bytecode null check

    spmid_ = value;
  }
  /**
   * <pre>
   * spmid 页面id
   * </pre>
   *
   * <code>string spmid = 4;</code>
   */
  private void clearSpmid() {

    spmid_ = getDefaultInstance().getSpmid();
  }
  /**
   * <pre>
   * spmid 页面id
   * </pre>
   *
   * <code>string spmid = 4;</code>
   * @param value The bytes for spmid to set.
   */
  private void setSpmidBytes(
      com.google.protobuf.ByteString value) {
    checkByteStringIsUtf8(value);
    spmid_ = value.toStringUtf8();

  }

  public static com.bapis.bilibili.community.service.dm.v1.DmExpoReportReq parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DmExpoReportReq parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DmExpoReportReq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DmExpoReportReq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DmExpoReportReq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DmExpoReportReq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DmExpoReportReq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DmExpoReportReq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static com.bapis.bilibili.community.service.dm.v1.DmExpoReportReq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }

  public static com.bapis.bilibili.community.service.dm.v1.DmExpoReportReq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DmExpoReportReq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.bapis.bilibili.community.service.dm.v1.DmExpoReportReq parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return (Builder) DEFAULT_INSTANCE.createBuilder();
  }
  public static Builder newBuilder(com.bapis.bilibili.community.service.dm.v1.DmExpoReportReq prototype) {
    return DEFAULT_INSTANCE.createBuilder(prototype);
  }

  /**
   * Protobuf type {@code bilibili.community.service.dm.v1.DmExpoReportReq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        com.bapis.bilibili.community.service.dm.v1.DmExpoReportReq, Builder> implements
      // @@protoc_insertion_point(builder_implements:bilibili.community.service.dm.v1.DmExpoReportReq)
      com.bapis.bilibili.community.service.dm.v1.DmExpoReportReqOrBuilder {
    // Construct using com.bapis.bilibili.community.service.dm.v1.DmExpoReportReq.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <pre>
     * session id
     * </pre>
     *
     * <code>string session_id = 1;</code>
     * @return The sessionId.
     */
    @java.lang.Override
    public java.lang.String getSessionId() {
      return instance.getSessionId();
    }
    /**
     * <pre>
     * session id
     * </pre>
     *
     * <code>string session_id = 1;</code>
     * @return The bytes for sessionId.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getSessionIdBytes() {
      return instance.getSessionIdBytes();
    }
    /**
     * <pre>
     * session id
     * </pre>
     *
     * <code>string session_id = 1;</code>
     * @param value The sessionId to set.
     * @return This builder for chaining.
     */
    public Builder setSessionId(
        java.lang.String value) {
      copyOnWrite();
      instance.setSessionId(value);
      return this;
    }
    /**
     * <pre>
     * session id
     * </pre>
     *
     * <code>string session_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearSessionId() {
      copyOnWrite();
      instance.clearSessionId();
      return this;
    }
    /**
     * <pre>
     * session id
     * </pre>
     *
     * <code>string session_id = 1;</code>
     * @param value The bytes for sessionId to set.
     * @return This builder for chaining.
     */
    public Builder setSessionIdBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setSessionIdBytes(value);
      return this;
    }

    /**
     * <pre>
     * oid 视频id
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
     * oid 视频id
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
     * oid 视频id
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
     * gzip dmid, 逗号分隔
     * </pre>
     *
     * <code>bytes dmids = 3;</code>
     * @return The dmids.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getDmids() {
      return instance.getDmids();
    }
    /**
     * <pre>
     * gzip dmid, 逗号分隔
     * </pre>
     *
     * <code>bytes dmids = 3;</code>
     * @param value The dmids to set.
     * @return This builder for chaining.
     */
    public Builder setDmids(com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setDmids(value);
      return this;
    }
    /**
     * <pre>
     * gzip dmid, 逗号分隔
     * </pre>
     *
     * <code>bytes dmids = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearDmids() {
      copyOnWrite();
      instance.clearDmids();
      return this;
    }

    /**
     * <pre>
     * spmid 页面id
     * </pre>
     *
     * <code>string spmid = 4;</code>
     * @return The spmid.
     */
    @java.lang.Override
    public java.lang.String getSpmid() {
      return instance.getSpmid();
    }
    /**
     * <pre>
     * spmid 页面id
     * </pre>
     *
     * <code>string spmid = 4;</code>
     * @return The bytes for spmid.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getSpmidBytes() {
      return instance.getSpmidBytes();
    }
    /**
     * <pre>
     * spmid 页面id
     * </pre>
     *
     * <code>string spmid = 4;</code>
     * @param value The spmid to set.
     * @return This builder for chaining.
     */
    public Builder setSpmid(
        java.lang.String value) {
      copyOnWrite();
      instance.setSpmid(value);
      return this;
    }
    /**
     * <pre>
     * spmid 页面id
     * </pre>
     *
     * <code>string spmid = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearSpmid() {
      copyOnWrite();
      instance.clearSpmid();
      return this;
    }
    /**
     * <pre>
     * spmid 页面id
     * </pre>
     *
     * <code>string spmid = 4;</code>
     * @param value The bytes for spmid to set.
     * @return This builder for chaining.
     */
    public Builder setSpmidBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setSpmidBytes(value);
      return this;
    }

    // @@protoc_insertion_point(builder_scope:bilibili.community.service.dm.v1.DmExpoReportReq)
  }
  @java.lang.Override
  @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
  protected final java.lang.Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      java.lang.Object arg0, java.lang.Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new com.bapis.bilibili.community.service.dm.v1.DmExpoReportReq();
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case BUILD_MESSAGE_INFO: {
          java.lang.Object[] objects = new java.lang.Object[] {
            "sessionId_",
            "oid_",
            "dmids_",
            "spmid_",
          };
          java.lang.String info =
              "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0208\u0002\u0002" +
              "\u0003\n\u0004\u0208";
          return newMessageInfo(DEFAULT_INSTANCE, info, objects);
      }
      // fall through
      case GET_DEFAULT_INSTANCE: {
        return DEFAULT_INSTANCE;
      }
      case GET_PARSER: {
        com.google.protobuf.Parser<com.bapis.bilibili.community.service.dm.v1.DmExpoReportReq> parser = PARSER;
        if (parser == null) {
          synchronized (com.bapis.bilibili.community.service.dm.v1.DmExpoReportReq.class) {
            parser = PARSER;
            if (parser == null) {
              parser =
                  new DefaultInstanceBasedParser<com.bapis.bilibili.community.service.dm.v1.DmExpoReportReq>(
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


  // @@protoc_insertion_point(class_scope:bilibili.community.service.dm.v1.DmExpoReportReq)
  private static final com.bapis.bilibili.community.service.dm.v1.DmExpoReportReq DEFAULT_INSTANCE;
  static {
    DmExpoReportReq defaultInstance = new DmExpoReportReq();
    // New instances are implicitly immutable so no need to make
    // immutable.
    DEFAULT_INSTANCE = defaultInstance;
    com.google.protobuf.GeneratedMessageLite.registerDefaultInstance(
      DmExpoReportReq.class, defaultInstance);
  }

  public static com.bapis.bilibili.community.service.dm.v1.DmExpoReportReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<DmExpoReportReq> PARSER;

  public static com.google.protobuf.Parser<DmExpoReportReq> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}
