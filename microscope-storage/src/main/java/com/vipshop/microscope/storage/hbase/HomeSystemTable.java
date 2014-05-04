package com.vipshop.microscope.storage.hbase;

import com.vipshop.microscope.trace.system.SystemData;
import org.apache.hadoop.hbase.util.Bytes;

public class HomeSystemTable {

    // ********* Hbase schema for system table *********** //

    public static final String TABLE_NAME = "home_system";

    public static final String CF = "cf";
    public static final byte[] BYTE_CF = Bytes.toBytes(CF);
    public static final String C_SYSTEM = "system";
    public static final byte[] BYTE_C_SYSTEM = Bytes.toBytes(C_SYSTEM);

    public static String rowKey(SystemData info) {
        return info.getApp() + info.getHost();
    }

}