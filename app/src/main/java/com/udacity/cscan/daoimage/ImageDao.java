package com.udacity.cscan.daoimage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table "IMAGE".
 */
public class ImageDao extends AbstractDao<Image, Long> {

    public static final String TABLENAME = "IMAGE";

    /**
     * Properties of entity Image.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Title = new Property(1, String.class, "title", false, "TITLE");
        public final static Property Comment = new Property(2, String.class, "comment", false, "COMMENT");
        public final static Property Imageurl = new Property(3, String.class, "imageurl", false, "IMAGEURL");
        public final static Property Date = new Property(4, java.util.Date.class, "date", false, "DATE");
        public final static Property Formateddate = new Property(5, String.class, "formateddate", false, "FORMATEDDATE");
    }

    ;


    public ImageDao(DaoConfig config) {
        super(config);
    }

    public ImageDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /**
     * Creates the underlying database table.
     */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists ? "IF NOT EXISTS " : "";
        db.execSQL("CREATE TABLE " + constraint + "\"IMAGE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"TITLE\" TEXT NOT NULL ," + // 1: title
                "\"COMMENT\" TEXT," + // 2: comment
                "\"IMAGEURL\" TEXT NOT NULL ," + // 3: imageurl
                "\"DATE\" INTEGER," + // 4: date
                "\"FORMATEDDATE\" TEXT);"); // 5: formateddate
    }

    /**
     * Drops the underlying database table.
     */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"IMAGE\"";
        db.execSQL(sql);
    }

    /**
     * @inheritdoc
     */
    @Override
    protected void bindValues(SQLiteStatement stmt, Image entity) {
        stmt.clearBindings();

        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getTitle());

        String comment = entity.getComment();
        if (comment != null) {
            stmt.bindString(3, comment);
        }
        stmt.bindString(4, entity.getImageurl());

        java.util.Date date = entity.getDate();
        if (date != null) {
            stmt.bindLong(5, date.getTime());
        }

        String formateddate = entity.getFormateddate();
        if (formateddate != null) {
            stmt.bindString(6, formateddate);
        }
    }

    /**
     * @inheritdoc
     */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }

    /**
     * @inheritdoc
     */
    @Override
    public Image readEntity(Cursor cursor, int offset) {
        Image entity = new Image( //
                cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
                cursor.getString(offset + 1), // title
                cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // comment
                cursor.getString(offset + 3), // imageurl
                cursor.isNull(offset + 4) ? null : new java.util.Date(cursor.getLong(offset + 4)), // date
                cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // formateddate
        );
        return entity;
    }

    /**
     * @inheritdoc
     */
    @Override
    public void readEntity(Cursor cursor, Image entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTitle(cursor.getString(offset + 1));
        entity.setComment(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setImageurl(cursor.getString(offset + 3));
        entity.setDate(cursor.isNull(offset + 4) ? null : new java.util.Date(cursor.getLong(offset + 4)));
        entity.setFormateddate(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
    }

    /**
     * @inheritdoc
     */
    @Override
    protected Long updateKeyAfterInsert(Image entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }

    /**
     * @inheritdoc
     */
    @Override
    public Long getKey(Image entity) {
        if (entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /**
     * @inheritdoc
     */
    @Override
    protected boolean isEntityUpdateable() {
        return true;
    }

}
