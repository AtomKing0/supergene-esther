package com.ironsource.mediationsdk.metadata;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class MetaData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f13678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f13679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<MetaDataValueTypes> f13680c;

    public enum MetaDataValueTypes {
        META_DATA_VALUE_STRING,
        META_DATA_VALUE_BOOLEAN,
        META_DATA_VALUE_INT,
        META_DATA_VALUE_LONG,
        META_DATA_VALUE_DOUBLE,
        META_DATA_VALUE_FLOAT
    }

    public MetaData(String str, List<String> list) {
        this.f13678a = str;
        this.f13679b = list;
        this.f13680c = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            this.f13680c.add(MetaDataValueTypes.META_DATA_VALUE_STRING);
        }
    }

    public String getMetaDataKey() {
        return this.f13678a;
    }

    public List<String> getMetaDataValue() {
        return this.f13679b;
    }

    public List<MetaDataValueTypes> getMetaDataValueType() {
        return this.f13680c;
    }

    public MetaData(String str, List<String> list, List<MetaDataValueTypes> list2) {
        this.f13678a = str;
        this.f13679b = list;
        this.f13680c = list2;
    }
}
