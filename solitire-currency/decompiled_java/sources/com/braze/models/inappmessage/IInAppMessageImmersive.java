package com.braze.models.inappmessage;

import com.braze.enums.inappmessage.ImageStyle;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IInAppMessageImmersive extends IInAppMessage {
    String getHeader();

    ImageStyle getImageStyle();

    List<MessageButton> getMessageButtons();

    boolean logButtonClick(MessageButton messageButton);
}
