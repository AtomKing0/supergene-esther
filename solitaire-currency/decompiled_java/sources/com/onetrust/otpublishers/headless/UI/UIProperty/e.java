package com.onetrust.otpublishers.headless.UI.UIProperty;

import androidx.annotation.NonNull;
import com.ironsource.f5;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class e {
    public static void a(@NonNull com.onetrust.otpublishers.headless.UI.DataModels.c cVar, @NonNull JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("customPreferences")) {
            ArrayList<com.onetrust.otpublishers.headless.UI.DataModels.b> arrayList = new ArrayList<>();
            JSONArray jSONArray = jSONObject.getJSONArray("customPreferences");
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                com.onetrust.otpublishers.headless.UI.DataModels.b bVar = new com.onetrust.otpublishers.headless.UI.DataModels.b();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                if (jSONObject2.has("id")) {
                    bVar.f22059a = jSONObject2.optString("id");
                }
                if (jSONObject2.has("name")) {
                    bVar.f22060b = jSONObject2.optString("name");
                }
                if (jSONObject2.has("description")) {
                    bVar.f22061c = jSONObject2.optString("description");
                }
                if (jSONObject2.has("selectionType")) {
                    bVar.f22062d = jSONObject2.optString("selectionType");
                }
                if (jSONObject2.has("purposeId")) {
                    jSONObject2.optString("purposeId");
                }
                if (jSONObject2.has("customPreferenceOptions")) {
                    ArrayList<com.onetrust.otpublishers.headless.UI.DataModels.d> arrayList2 = new ArrayList<>();
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("customPreferenceOptions");
                    for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                        com.onetrust.otpublishers.headless.UI.DataModels.d dVar = new com.onetrust.otpublishers.headless.UI.DataModels.d();
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i11);
                        if (jSONObject3.has("id")) {
                            dVar.f22076a = jSONObject3.optString("id");
                        }
                        if (jSONObject3.has("label")) {
                            dVar.f22080e = jSONObject3.optString("label");
                        }
                        if (jSONObject3.has(f5.f12053t)) {
                            dVar.f22081f = jSONObject3.optString(f5.f12053t);
                        }
                        if (jSONObject3.has("isDefault")) {
                            dVar.f22082g = jSONObject3.optString("isDefault");
                        }
                        if (jSONObject3.has("canDelete")) {
                            dVar.f22077b = jSONObject3.optString("canDelete");
                        }
                        if (jSONObject3.has("purposeOptionsId")) {
                            dVar.f22084i = jSONObject3.optString("purposeOptionsId");
                        }
                        if (jSONObject3.has("purposeId")) {
                            dVar.f22085j = jSONObject3.optString("purposeId");
                        }
                        if (jSONObject3.has("userConsentStatus")) {
                            dVar.f22083h = jSONObject3.optString("userConsentStatus");
                        }
                        if (jSONObject3.has("customPreferenceId")) {
                            dVar.f22086k = jSONObject3.optString("customPreferenceId");
                        }
                        arrayList2.add(dVar);
                    }
                    bVar.f22064f = arrayList2;
                }
                arrayList.add(bVar);
            }
            cVar.f22074j = arrayList;
        }
    }

    public static void b(@NonNull com.onetrust.otpublishers.headless.UI.DataModels.c cVar, @NonNull JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("topics")) {
            ArrayList<com.onetrust.otpublishers.headless.UI.DataModels.e> arrayList = new ArrayList<>();
            JSONArray jSONArray = jSONObject.getJSONArray("topics");
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                com.onetrust.otpublishers.headless.UI.DataModels.e eVar = new com.onetrust.otpublishers.headless.UI.DataModels.e();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                if (jSONObject2.has("name")) {
                    eVar.f22088a = jSONObject2.optString("name");
                }
                if (jSONObject2.has("options")) {
                    ArrayList<com.onetrust.otpublishers.headless.UI.DataModels.d> arrayList2 = new ArrayList<>();
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("options");
                    for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                        com.onetrust.otpublishers.headless.UI.DataModels.d dVar = new com.onetrust.otpublishers.headless.UI.DataModels.d();
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i11);
                        if (jSONObject3.has("id")) {
                            dVar.f22076a = jSONObject3.optString("id");
                        }
                        if (jSONObject3.has("name")) {
                            dVar.f22078c = jSONObject3.optString("name");
                        }
                        if (jSONObject3.has("integrationKey")) {
                            dVar.f22079d = jSONObject3.optString("integrationKey");
                        }
                        if (jSONObject3.has("customPreferenceId")) {
                            dVar.f22084i = jSONObject3.optString("customPreferenceId");
                        }
                        if (jSONObject3.has("purposeId")) {
                            dVar.f22085j = jSONObject3.optString("purposeId");
                        }
                        if (jSONObject3.has("userConsentStatus")) {
                            dVar.f22083h = jSONObject3.optString("userConsentStatus");
                        }
                        if (jSONObject3.has("purposeTopicId")) {
                            dVar.f22087l = jSONObject3.optString("purposeTopicId");
                        }
                        arrayList2.add(dVar);
                    }
                    eVar.f22089b = arrayList2;
                }
                arrayList.add(eVar);
            }
            cVar.f22073i = arrayList;
        }
    }

    public static void c(com.onetrust.otpublishers.headless.UI.DataModels.c cVar, JSONObject jSONObject) {
        if (jSONObject.has("id")) {
            cVar.f22065a = jSONObject.optString("id");
        }
        if (jSONObject.has("label")) {
            cVar.f22066b = jSONObject.optString("label");
        }
        if (jSONObject.has("description")) {
            cVar.f22067c = jSONObject.optString("description");
        }
        if (jSONObject.has("status")) {
            cVar.f22068d = jSONObject.optString("status");
        }
        if (jSONObject.has("newVersionAvailable")) {
            cVar.f22069e = jSONObject.optString("newVersionAvailable");
        }
        if (jSONObject.has("type")) {
            cVar.f22070f = jSONObject.optString("type");
        }
        if (jSONObject.has("consentLifeSpan")) {
            cVar.f22071g = jSONObject.optString("consentLifeSpan");
        }
        if (jSONObject.has("version")) {
            cVar.f22072h = jSONObject.optString("version");
        }
        if (jSONObject.has("userConsentStatus")) {
            cVar.f22075k = jSONObject.optString("userConsentStatus");
        }
    }
}
