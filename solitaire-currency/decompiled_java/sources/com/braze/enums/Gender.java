package com.braze.enums;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.braze.models.IPutIntoJson;
import com.ironsource.nb;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes2.dex */
public enum Gender implements IPutIntoJson<String> {
    MALE("m"),
    FEMALE("f"),
    OTHER("o"),
    UNKNOWN("u"),
    NOT_APPLICABLE(nb.f14119q),
    PREFER_NOT_TO_SAY(TtmlNode.TAG_P);

    public static final Companion Companion = new Companion(null);
    private final String value;

    public static final class Companion {
        public /* synthetic */ Companion(k kVar) {
            this();
        }

        private Companion() {
        }
    }

    Gender(String str) {
        this.value = str;
    }

    @Override // com.braze.models.IPutIntoJson
    public String forJsonPut() {
        return this.value;
    }
}
