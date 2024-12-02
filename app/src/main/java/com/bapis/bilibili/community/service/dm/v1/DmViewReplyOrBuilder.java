// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: bilibili/community/service/dm/v1/dm.proto
// Protobuf Java Version: 4.29.0

package com.bapis.bilibili.community.service.dm.v1;

public interface DmViewReplyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:bilibili.community.service.dm.v1.DmViewReply)
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
   * 视频弹幕蒙版
   * </pre>
   *
   * <code>.bilibili.community.service.dm.v1.VideoMask mask = 2;</code>
   * @return Whether the mask field is set.
   */
  boolean hasMask();
  /**
   * <pre>
   * 视频弹幕蒙版
   * </pre>
   *
   * <code>.bilibili.community.service.dm.v1.VideoMask mask = 2;</code>
   * @return The mask.
   */
  com.bapis.bilibili.community.service.dm.v1.VideoMask getMask();

  /**
   * <pre>
   * 视频字幕
   * </pre>
   *
   * <code>.bilibili.community.service.dm.v1.VideoSubtitle subtitle = 3;</code>
   * @return Whether the subtitle field is set.
   */
  boolean hasSubtitle();
  /**
   * <pre>
   * 视频字幕
   * </pre>
   *
   * <code>.bilibili.community.service.dm.v1.VideoSubtitle subtitle = 3;</code>
   * @return The subtitle.
   */
  com.bapis.bilibili.community.service.dm.v1.VideoSubtitle getSubtitle();

  /**
   * <pre>
   * 高级弹幕链接地址 （上传到bfs）
   * </pre>
   *
   * <code>repeated string special_dms = 4;</code>
   * @return A list containing the specialDms.
   */
  java.util.List<java.lang.String>
      getSpecialDmsList();
  /**
   * <pre>
   * 高级弹幕链接地址 （上传到bfs）
   * </pre>
   *
   * <code>repeated string special_dms = 4;</code>
   * @return The count of specialDms.
   */
  int getSpecialDmsCount();
  /**
   * <pre>
   * 高级弹幕链接地址 （上传到bfs）
   * </pre>
   *
   * <code>repeated string special_dms = 4;</code>
   * @param index The index of the element to return.
   * @return The specialDms at the given index.
   */
  java.lang.String getSpecialDms(int index);
  /**
   * <pre>
   * 高级弹幕链接地址 （上传到bfs）
   * </pre>
   *
   * <code>repeated string special_dms = 4;</code>
   * @param index The index of the element to return.
   * @return The specialDms at the given index.
   */
  com.google.protobuf.ByteString
      getSpecialDmsBytes(int index);

  /**
   * <pre>
   * ai打分 只返回flag + 文案，给客户端展示使用
   * </pre>
   *
   * <code>.bilibili.community.service.dm.v1.DanmakuFlagConfig ai_flag = 5;</code>
   * @return Whether the aiFlag field is set.
   */
  boolean hasAiFlag();
  /**
   * <pre>
   * ai打分 只返回flag + 文案，给客户端展示使用
   * </pre>
   *
   * <code>.bilibili.community.service.dm.v1.DanmakuFlagConfig ai_flag = 5;</code>
   * @return The aiFlag.
   */
  com.bapis.bilibili.community.service.dm.v1.DanmakuFlagConfig getAiFlag();

  /**
   * <pre>
   * dm player config
   * </pre>
   *
   * <code>.bilibili.community.service.dm.v1.DanmuPlayerViewConfig player_config = 6;</code>
   * @return Whether the playerConfig field is set.
   */
  boolean hasPlayerConfig();
  /**
   * <pre>
   * dm player config
   * </pre>
   *
   * <code>.bilibili.community.service.dm.v1.DanmuPlayerViewConfig player_config = 6;</code>
   * @return The playerConfig.
   */
  com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig getPlayerConfig();

  /**
   * <pre>
   * 弹幕发送框样式[0,1],0:new,1:old
   * </pre>
   *
   * <code>int32 send_box_style = 7;</code>
   * @return The sendBoxStyle.
   */
  int getSendBoxStyle();

  /**
   * <pre>
   * 是否允许
   * </pre>
   *
   * <code>bool allow = 8;</code>
   * @return The allow.
   */
  boolean getAllow();

  /**
   * <pre>
   * check box 是否展示
   * </pre>
   *
   * <code>bool check_box = 9;</code>
   * @return The checkBox.
   */
  boolean getCheckBox();

  /**
   * <pre>
   * check box 展示文本
   * </pre>
   *
   * <code>string check_box_show_msg = 10;</code>
   * @return The checkBoxShowMsg.
   */
  java.lang.String getCheckBoxShowMsg();
  /**
   * <pre>
   * check box 展示文本
   * </pre>
   *
   * <code>string check_box_show_msg = 10;</code>
   * @return The bytes for checkBoxShowMsg.
   */
  com.google.protobuf.ByteString
      getCheckBoxShowMsgBytes();

  /**
   * <pre>
   * 展示文案
   * </pre>
   *
   * <code>string text_placeholder = 11;</code>
   * @return The textPlaceholder.
   */
  java.lang.String getTextPlaceholder();
  /**
   * <pre>
   * 展示文案
   * </pre>
   *
   * <code>string text_placeholder = 11;</code>
   * @return The bytes for textPlaceholder.
   */
  com.google.protobuf.ByteString
      getTextPlaceholderBytes();

  /**
   * <pre>
   * 弹幕发送框文本
   * </pre>
   *
   * <code>string input_placeholder = 12;</code>
   * @return The inputPlaceholder.
   */
  java.lang.String getInputPlaceholder();
  /**
   * <pre>
   * 弹幕发送框文本
   * </pre>
   *
   * <code>string input_placeholder = 12;</code>
   * @return The bytes for inputPlaceholder.
   */
  com.google.protobuf.ByteString
      getInputPlaceholderBytes();

  /**
   * <pre>
   * 用户举报弹幕，cid维度屏蔽的正则规则
   * </pre>
   *
   * <code>repeated string report_filter_content = 13;</code>
   * @return A list containing the reportFilterContent.
   */
  java.util.List<java.lang.String>
      getReportFilterContentList();
  /**
   * <pre>
   * 用户举报弹幕，cid维度屏蔽的正则规则
   * </pre>
   *
   * <code>repeated string report_filter_content = 13;</code>
   * @return The count of reportFilterContent.
   */
  int getReportFilterContentCount();
  /**
   * <pre>
   * 用户举报弹幕，cid维度屏蔽的正则规则
   * </pre>
   *
   * <code>repeated string report_filter_content = 13;</code>
   * @param index The index of the element to return.
   * @return The reportFilterContent at the given index.
   */
  java.lang.String getReportFilterContent(int index);
  /**
   * <pre>
   * 用户举报弹幕，cid维度屏蔽的正则规则
   * </pre>
   *
   * <code>repeated string report_filter_content = 13;</code>
   * @param index The index of the element to return.
   * @return The reportFilterContent at the given index.
   */
  com.google.protobuf.ByteString
      getReportFilterContentBytes(int index);

  /**
   * <pre>
   * 弹幕曝光上报，dmid维度
   * </pre>
   *
   * <code>.bilibili.community.service.dm.v1.ExpoReport expo_report = 14;</code>
   * @return Whether the expoReport field is set.
   */
  boolean hasExpoReport();
  /**
   * <pre>
   * 弹幕曝光上报，dmid维度
   * </pre>
   *
   * <code>.bilibili.community.service.dm.v1.ExpoReport expo_report = 14;</code>
   * @return The expoReport.
   */
  com.bapis.bilibili.community.service.dm.v1.ExpoReport getExpoReport();

  /**
   * <pre>
   * 热梗配置
   * </pre>
   *
   * <code>.bilibili.community.service.dm.v1.BuzzwordConfig buzzword_config = 15;</code>
   * @return Whether the buzzwordConfig field is set.
   */
  boolean hasBuzzwordConfig();
  /**
   * <pre>
   * 热梗配置
   * </pre>
   *
   * <code>.bilibili.community.service.dm.v1.BuzzwordConfig buzzword_config = 15;</code>
   * @return The buzzwordConfig.
   */
  com.bapis.bilibili.community.service.dm.v1.BuzzwordConfig getBuzzwordConfig();

  /**
   * <pre>
   * 图片弹幕
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.Expressions expressions = 16;</code>
   */
  java.util.List<com.bapis.bilibili.community.service.dm.v1.Expressions> 
      getExpressionsList();
  /**
   * <pre>
   * 图片弹幕
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.Expressions expressions = 16;</code>
   */
  com.bapis.bilibili.community.service.dm.v1.Expressions getExpressions(int index);
  /**
   * <pre>
   * 图片弹幕
   * </pre>
   *
   * <code>repeated .bilibili.community.service.dm.v1.Expressions expressions = 16;</code>
   */
  int getExpressionsCount();
}
