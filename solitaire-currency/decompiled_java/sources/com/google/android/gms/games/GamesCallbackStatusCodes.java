package com.google.android.gms.games;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class GamesCallbackStatusCodes {

    @Deprecated
    public static final int CLIENT_RECONNECT_REQUIRED = 2;
    public static final int INTERNAL_ERROR = 1;
    public static final int OK = 0;

    private GamesCallbackStatusCodes() {
    }

    @NonNull
    public static String getStatusCodeString(int i10) {
        if (i10 == 0) {
            return "OK";
        }
        if (i10 == 1) {
            return "INTERNAL_ERROR";
        }
        if (i10 == 2) {
            return "CLIENT_RECONNECT_REQUIRED";
        }
        if (i10 == 6003) {
            return "MULTIPLAYER_DISABLED";
        }
        if (i10 == 7004) {
            return "REAL_TIME_ROOM_NOT_JOINED";
        }
        if (i10 == 7000) {
            return "REAL_TIME_CONNECTION_FAILED";
        }
        if (i10 == 7001) {
            return "REAL_TIME_MESSAGE_SEND_FAILED";
        }
        StringBuilder sb = new StringBuilder(47);
        sb.append("unknown games callback status code: ");
        sb.append(i10);
        return sb.toString();
    }
}
