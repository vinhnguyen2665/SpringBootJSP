package com.vinhnq.beans;


import java.net.URI;
import java.util.List;

public class NotificationBeans {
    private Long id;
    private String title;
    private String titleLocKey;
    private String[] titleLocArgs;
    private String body;
    private String bodyLocKey;
    private String[] bodyLocArgs;
    private String icon;
    private String imageUrl;
    private String sound;
    private String tag;
    private String color;
    private String clickAction;
    private String channelId;
    private URI link;
    private String ticker;
    private Integer notificationPriority;
    private Integer visibility;
    private Integer notificationCount;
    private int[] lightSettings;
    private Long eventTime;
    private boolean sticky;
    private boolean localOnly;
    private boolean defaultSound;
    private boolean defaultVibrateTimings;
    private boolean defaultLightSettings;
    private long[] vibrateTimings;

    private List<Long> listDeviceId;

    public NotificationBeans() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleLocKey() {
        return titleLocKey;
    }

    public void setTitleLocKey(String titleLocKey) {
        this.titleLocKey = titleLocKey;
    }

    public String[] getTitleLocArgs() {
        return titleLocArgs;
    }

    public void setTitleLocArgs(String[] titleLocArgs) {
        this.titleLocArgs = titleLocArgs;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBodyLocKey() {
        return bodyLocKey;
    }

    public void setBodyLocKey(String bodyLocKey) {
        this.bodyLocKey = bodyLocKey;
    }

    public String[] getBodyLocArgs() {
        return bodyLocArgs;
    }

    public void setBodyLocArgs(String[] bodyLocArgs) {
        this.bodyLocArgs = bodyLocArgs;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getClickAction() {
        return clickAction;
    }

    public void setClickAction(String clickAction) {
        this.clickAction = clickAction;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public URI getLink() {
        return link;
    }

    public void setLink(URI link) {
        this.link = link;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Integer getNotificationPriority() {
        return notificationPriority;
    }

    public void setNotificationPriority(Integer notificationPriority) {
        this.notificationPriority = notificationPriority;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Integer getNotificationCount() {
        return notificationCount;
    }

    public void setNotificationCount(Integer notificationCount) {
        this.notificationCount = notificationCount;
    }

    public int[] getLightSettings() {
        return lightSettings;
    }

    public void setLightSettings(int[] lightSettings) {
        this.lightSettings = lightSettings;
    }

    public Long getEventTime() {
        return eventTime;
    }

    public void setEventTime(Long eventTime) {
        this.eventTime = eventTime;
    }

    public boolean isSticky() {
        return sticky;
    }

    public void setSticky(boolean sticky) {
        this.sticky = sticky;
    }

    public boolean isLocalOnly() {
        return localOnly;
    }

    public void setLocalOnly(boolean localOnly) {
        this.localOnly = localOnly;
    }

    public boolean isDefaultSound() {
        return defaultSound;
    }

    public void setDefaultSound(boolean defaultSound) {
        this.defaultSound = defaultSound;
    }

    public boolean isDefaultVibrateTimings() {
        return defaultVibrateTimings;
    }

    public void setDefaultVibrateTimings(boolean defaultVibrateTimings) {
        this.defaultVibrateTimings = defaultVibrateTimings;
    }

    public boolean isDefaultLightSettings() {
        return defaultLightSettings;
    }

    public void setDefaultLightSettings(boolean defaultLightSettings) {
        this.defaultLightSettings = defaultLightSettings;
    }

    public long[] getVibrateTimings() {
        return vibrateTimings;
    }

    public void setVibrateTimings(long[] vibrateTimings) {
        this.vibrateTimings = vibrateTimings;
    }

    public List<Long> getListDeviceId() {
        return listDeviceId;
    }

    public void setListDeviceId(List<Long> listDeviceId) {
        this.listDeviceId = listDeviceId;
    }
}
