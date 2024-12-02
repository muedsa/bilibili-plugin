// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: bilibili/community/service/dm/v1/dm.proto
// Protobuf Java Version: 4.29.0

package com.bapis.bilibili.community.service.dm.v1;

/**
 * <pre>
 * ExpoReport 弹幕曝光上报，dmid维度
 * </pre>
 *
 * Protobuf type {@code bilibili.community.service.dm.v1.ExpoReport}
 */
public  final class ExpoReport extends
    com.google.protobuf.GeneratedMessageLite<
        ExpoReport, ExpoReport.Builder> implements
    // @@protoc_insertion_point(message_implements:bilibili.community.service.dm.v1.ExpoReport)
    ExpoReportOrBuilder {
  private ExpoReport() {
  }
  public static final int SHOULD_REPORT_AT_END_FIELD_NUMBER = 1;
  private boolean shouldReportAtEnd_;
  /**
   * <pre>
   * 是否在视频结束后上报
   * </pre>
   *
   * <code>bool should_report_at_end = 1;</code>
   * @return The shouldReportAtEnd.
   */
  @java.lang.Override
  public boolean getShouldReportAtEnd() {
    return shouldReportAtEnd_;
  }
  /**
   * <pre>
   * 是否在视频结束后上报
   * </pre>
   *
   * <code>bool should_report_at_end = 1;</code>
   * @param value The shouldReportAtEnd to set.
   */
  private void setShouldReportAtEnd(boolean value) {
    
    shouldReportAtEnd_ = value;
  }
  /**
   * <pre>
   * 是否在视频结束后上报
   * </pre>
   *
   * <code>bool should_report_at_end = 1;</code>
   */
  private void clearShouldReportAtEnd() {

    shouldReportAtEnd_ = false;
  }

  public static com.bapis.bilibili.community.service.dm.v1.ExpoReport parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.ExpoReport parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.ExpoReport parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.ExpoReport parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.ExpoReport parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.bapis.bilibili.community.service.dm.v1.ExpoReport parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.ExpoReport parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.bapis.bilibili.community.service.dm.v1.ExpoReport parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static com.bapis.bilibili.community.service.dm.v1.ExpoReport parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }

  public static com.bapis.bilibili.community.service.dm.v1.ExpoReport parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static com.bapis.bilibili.community.service.dm.v1.ExpoReport parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.bapis.bilibili.community.service.dm.v1.ExpoReport parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return (Builder) DEFAULT_INSTANCE.createBuilder();
  }
  public static Builder newBuilder(com.bapis.bilibili.community.service.dm.v1.ExpoReport prototype) {
    return DEFAULT_INSTANCE.createBuilder(prototype);
  }

  /**
   * <pre>
   * ExpoReport 弹幕曝光上报，dmid维度
   * </pre>
   *
   * Protobuf type {@code bilibili.community.service.dm.v1.ExpoReport}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        com.bapis.bilibili.community.service.dm.v1.ExpoReport, Builder> implements
      // @@protoc_insertion_point(builder_implements:bilibili.community.service.dm.v1.ExpoReport)
      com.bapis.bilibili.community.service.dm.v1.ExpoReportOrBuilder {
    // Construct using com.bapis.bilibili.community.service.dm.v1.ExpoReport.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <pre>
     * 是否在视频结束后上报
     * </pre>
     *
     * <code>bool should_report_at_end = 1;</code>
     * @return The shouldReportAtEnd.
     */
    @java.lang.Override
    public boolean getShouldReportAtEnd() {
      return instance.getShouldReportAtEnd();
    }
    /**
     * <pre>
     * 是否在视频结束后上报
     * </pre>
     *
     * <code>bool should_report_at_end = 1;</code>
     * @param value The shouldReportAtEnd to set.
     * @return This builder for chaining.
     */
    public Builder setShouldReportAtEnd(boolean value) {
      copyOnWrite();
      instance.setShouldReportAtEnd(value);
      return this;
    }
    /**
     * <pre>
     * 是否在视频结束后上报
     * </pre>
     *
     * <code>bool should_report_at_end = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearShouldReportAtEnd() {
      copyOnWrite();
      instance.clearShouldReportAtEnd();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:bilibili.community.service.dm.v1.ExpoReport)
  }
  @java.lang.Override
  @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
  protected final java.lang.Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      java.lang.Object arg0, java.lang.Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new com.bapis.bilibili.community.service.dm.v1.ExpoReport();
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case BUILD_MESSAGE_INFO: {
          java.lang.Object[] objects = new java.lang.Object[] {
            "shouldReportAtEnd_",
          };
          java.lang.String info =
              "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007";
          return newMessageInfo(DEFAULT_INSTANCE, info, objects);
      }
      // fall through
      case GET_DEFAULT_INSTANCE: {
        return DEFAULT_INSTANCE;
      }
      case GET_PARSER: {
        com.google.protobuf.Parser<com.bapis.bilibili.community.service.dm.v1.ExpoReport> parser = PARSER;
        if (parser == null) {
          synchronized (com.bapis.bilibili.community.service.dm.v1.ExpoReport.class) {
            parser = PARSER;
            if (parser == null) {
              parser =
                  new DefaultInstanceBasedParser<com.bapis.bilibili.community.service.dm.v1.ExpoReport>(
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


  // @@protoc_insertion_point(class_scope:bilibili.community.service.dm.v1.ExpoReport)
  private static final com.bapis.bilibili.community.service.dm.v1.ExpoReport DEFAULT_INSTANCE;
  static {
    ExpoReport defaultInstance = new ExpoReport();
    // New instances are implicitly immutable so no need to make
    // immutable.
    DEFAULT_INSTANCE = defaultInstance;
    com.google.protobuf.GeneratedMessageLite.registerDefaultInstance(
      ExpoReport.class, defaultInstance);
  }

  public static com.bapis.bilibili.community.service.dm.v1.ExpoReport getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<ExpoReport> PARSER;

  public static com.google.protobuf.Parser<ExpoReport> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

