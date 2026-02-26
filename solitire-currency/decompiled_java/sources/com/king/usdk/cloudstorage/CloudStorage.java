package com.king.usdk.cloudstorage;

import android.app.Activity;
import android.app.backup.BackupManager;
import android.content.SharedPreferences;
import androidx.annotation.Keep;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class CloudStorage {
    static final String PREFS = "CloudStorage";
    static final String PREFS_BACKUP_KEY = "couldStorageKey";
    BackupManager bm;
    SharedPreferences prefs;

    public CloudStorage(Activity activity) {
        this.prefs = activity.getSharedPreferences(PREFS, 0);
        this.bm = new BackupManager(activity);
    }

    private void RequestBackup() {
        this.bm.dataChanged();
    }

    public void ClearData() {
        SharedPreferences.Editor editorEdit = this.prefs.edit();
        editorEdit.clear();
        editorEdit.commit();
        RequestBackup();
    }

    public void ClearKey(String str) {
        SharedPreferences.Editor editorEdit = this.prefs.edit();
        editorEdit.remove(str);
        editorEdit.commit();
        RequestBackup();
    }

    public String Load(String str) {
        return this.prefs.getString(str, "");
    }

    public String[] LoadAll() {
        Map<String, ?> all = this.prefs.getAll();
        String[] strArr = new String[all.size() * 2];
        int i10 = 0;
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            strArr[i10] = entry.getKey();
            strArr[i10 + 1] = entry.getValue().toString();
            i10 += 2;
        }
        return strArr;
    }

    public void Save(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.prefs.edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
        RequestBackup();
    }
}
