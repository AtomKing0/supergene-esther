package com.ironsource.environment;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.ironsource.s9;
import com.unity3d.services.UnityAdsConstants;

/* JADX INFO: loaded from: classes4.dex */
public class CrashProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f11954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    s9 f11955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f11956c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Uri f11958e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    String f11961h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    String f11962i;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    UriMatcher f11957d = new UriMatcher(-1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f11959f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final int f11960g = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final String f11963j = "REPORTS";

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        int iMatch = this.f11957d.match(uri);
        if (iMatch == 1) {
            return this.f11961h;
        }
        if (iMatch == 2) {
            return this.f11962i;
        }
        throw new IllegalArgumentException("Invalid URI: " + uri);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f11954a = getContext();
        this.f11955b = new s9(this.f11954a);
        this.f11956c = this.f11954a.getPackageName();
        this.f11958e = Uri.parse("content://" + this.f11956c + UnityAdsConstants.DefaultUrls.AD_ASSET_PATH + "REPORTS");
        this.f11961h = "vnd.android.cursor.dir/CrashReporter.Reports";
        this.f11962i = "vnd.android.cursor.item/CrashReporter/Reports";
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int iMatch = this.f11957d.match(uri);
        if (iMatch == 1) {
            return s9.c();
        }
        if (iMatch == 2) {
            return s9.a(Integer.parseInt(uri.getLastPathSegment()));
        }
        throw new IllegalArgumentException("Invalid URI: " + uri);
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
