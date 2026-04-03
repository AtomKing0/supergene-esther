package com.braze.models.inappmessage;

import android.net.Uri;
import com.braze.enums.inappmessage.ClickAction;
import com.braze.enums.inappmessage.CropType;
import com.braze.enums.inappmessage.DismissType;
import com.braze.enums.inappmessage.MessageType;
import com.braze.enums.inappmessage.Orientation;
import com.braze.models.IPutIntoJson;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface IInAppMessage extends IPutIntoJson<JSONObject> {
    boolean getAnimateIn();

    boolean getAnimateOut();

    int getBackgroundColor();

    ClickAction getClickAction();

    CropType getCropType();

    DismissType getDismissType();

    int getDurationInMilliseconds();

    long getExpirationTimestamp();

    Map<String, String> getExtras();

    String getIcon();

    int getIconBackgroundColor();

    int getIconColor();

    String getMessage();

    int getMessageTextColor();

    MessageType getMessageType();

    boolean getOpenUriInWebView();

    Orientation getOrientation();

    List<String> getRemoteAssetPathsForPrefetch();

    Uri getUri();

    boolean isControl();

    boolean logClick();

    boolean logImpression();

    void onAfterClosed();

    void setAnimateIn(boolean z10);

    void setAnimateOut(boolean z10);

    void setExpirationTimestamp(long j10);

    void setLocalPrefetchedAssetPaths(Map<String, String> map);

    void setOrientation(Orientation orientation);

    void setTestSend(boolean z10);
}
