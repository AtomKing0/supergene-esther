package com.king.usdk.identitygpgs;

import android.app.Activity;
import androidx.annotation.Keep;
import com.google.android.gms.games.AuthenticationResult;
import com.google.android.gms.games.PlayGames;
import com.google.android.gms.games.PlayGamesSdk;
import com.google.android.gms.games.Player;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class GooglePlayServices {
    private static boolean mAuthenticated = false;
    private static Activity mGameActivity = null;
    private static boolean mInitialised = false;
    private static boolean mIsPC = false;
    private static String mOath2WebClientId = "";
    private static boolean mOnDoneNotified = false;
    private static String mPlayerId = "Undefined";
    private static String mServerAuthCode = "Undefined";
    private static a mSignInStatus = a.NOT_SIGNED_IN;
    private static final String name = "com.king.usdk.identitygpgs.GooglePlayServices";

    enum a {
        NOT_SIGNED_IN(1, "Not Signed In"),
        SIGNED_IN(2, "Signed In"),
        ERROR_UNCATEGORIZED(3, "Unexpected error not matching any of the other categories"),
        ERROR_GOOGLE_SIGN_IN(4, "Unexpected error from Google Play Games SDK when trying to sign-in"),
        ERROR_GOOGLE_GET_PLAYER(5, "Unexpected error from Google Play Games SDK when obtaining player info");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f17183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f17184b;

        a(int i10, String str) {
            this.f17183a = i10;
            this.f17184b = str;
        }
    }

    public GooglePlayServices(Activity activity, String str) {
        System.out.println("[GPGS] Java: Instantiated GooglePlayServices");
        mGameActivity = activity;
        mOath2WebClientId = str;
        mIsPC = activity.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE");
    }

    static void AbortGpgsFlow(Exception exc) {
        if (mGameActivity == null) {
            System.out.println("[GPGS] Java: GooglePlayServices not initialized correctly. GameActivity missing. Exception: " + exc.getMessage());
        } else {
            System.out.println("[GPGS] Java: GooglePlayServices API is not present on device. Exception: " + exc.getMessage());
        }
        mInitialised = true;
        mOnDoneNotified = true;
        mSignInStatus = a.ERROR_GOOGLE_SIGN_IN;
        NotifyOnDone();
    }

    static void CheckOnDone() {
        if (mPlayerId == "Undefined" || mOnDoneNotified) {
            return;
        }
        mOnDoneNotified = true;
        System.out.println("[GPGS] Java: Done.");
        NotifyOnDone();
    }

    public static String GetPlayerId() {
        return mPlayerId;
    }

    public static String GetServerAuthCode() {
        return mServerAuthCode;
    }

    public static int GetSignInStatus() {
        return mSignInStatus.f17183a;
    }

    private static native void NotifyOnDone();

    private static native void NotifyRequestServerAuthCodeDone(boolean z10);

    static void RequestPlayerId() {
        try {
            PlayGames.getPlayersClient(mGameActivity).getCurrentPlayer().addOnCompleteListener(new OnCompleteListener() { // from class: com.king.usdk.identitygpgs.c
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    GooglePlayServices.lambda$RequestPlayerId$1(task);
                }
            });
        } catch (Exception e10) {
            AbortGpgsFlow(e10);
        }
    }

    public static void RequestServerAuthCode() {
        RequestServerAuthenticationCode();
    }

    static void RequestServerAuthenticationCode() {
        try {
            PlayGames.getGamesSignInClient(mGameActivity).requestServerSideAccess(mOath2WebClientId, false).addOnCompleteListener(new OnCompleteListener() { // from class: com.king.usdk.identitygpgs.a
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    GooglePlayServices.lambda$RequestServerAuthenticationCode$2(task);
                }
            });
        } catch (Exception e10) {
            NotifyRequestServerAuthCodeDone(false);
            AbortGpgsFlow(e10);
        }
    }

    public static void SetupRecallApi() {
        try {
            PlayGames.getGamesSignInClient(mGameActivity).isAuthenticated().addOnCompleteListener(new OnCompleteListener() { // from class: com.king.usdk.identitygpgs.b
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    GooglePlayServices.lambda$SetupRecallApi$0(task);
                }
            });
        } catch (Exception e10) {
            AbortGpgsFlow(e10);
        }
    }

    public static void init() {
        initialize();
    }

    public static void initialize() {
        if (mInitialised) {
            return;
        }
        try {
            System.out.println(name);
            PlayGamesSdk.initialize(mGameActivity);
            mInitialised = true;
            SetupRecallApi();
        } catch (Exception e10) {
            AbortGpgsFlow(e10);
        }
    }

    public static boolean isAuthenticated() {
        return mAuthenticated;
    }

    public static boolean isAvailable() {
        return mGameActivity != null;
    }

    public static boolean isInitialised() {
        return mInitialised;
    }

    public static boolean isPC() {
        return mIsPC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$RequestPlayerId$1(Task task) {
        if (!((Player) task.getResult()).isDataValid()) {
            mSignInStatus = a.ERROR_GOOGLE_GET_PLAYER;
        }
        mPlayerId = ((Player) task.getResult()).getPlayerId();
        System.out.println("[GPGS] Java: Authenticated with playerId: " + mPlayerId);
        CheckOnDone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$RequestServerAuthenticationCode$2(Task task) {
        if (!task.isSuccessful()) {
            System.out.println("[GPGS] Java: Server AuthToken Failure");
            NotifyRequestServerAuthCodeDone(false);
            return;
        }
        mServerAuthCode = (String) task.getResult();
        System.out.println("[GPGS] Java: Server AuthToken: " + mServerAuthCode);
        NotifyRequestServerAuthCodeDone(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$SetupRecallApi$0(Task task) {
        if (task.isSuccessful() && ((AuthenticationResult) task.getResult()).isAuthenticated()) {
            System.out.println("[GPGS] Java: Authenticated");
            mSignInStatus = a.SIGNED_IN;
            RequestPlayerId();
            mAuthenticated = true;
            return;
        }
        mSignInStatus = a.NOT_SIGNED_IN;
        System.out.println("[GPGS] Java: Not authenticated");
        mOnDoneNotified = true;
        NotifyOnDone();
    }
}
