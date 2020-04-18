package com.android.ksih_covid_19_app.dataSource.local;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class Covid19RoomDatabase_Impl extends Covid19RoomDatabase {
  private volatile Covid19Dao _covid19Dao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `LiveByCountryAndStatusItem` (`Active` INTEGER NOT NULL, `Confirmed` INTEGER NOT NULL, `Country` TEXT NOT NULL, `CountryCode` TEXT NOT NULL, `Date` TEXT NOT NULL, `Deaths` INTEGER NOT NULL, `Lat` TEXT NOT NULL, `LocationID` TEXT NOT NULL, `Lon` TEXT NOT NULL, `Recovered` INTEGER NOT NULL, PRIMARY KEY(`Active`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `DayOneTotalResponseItem` (`Cases` INTEGER NOT NULL, `Country` TEXT NOT NULL, `CountryCode` TEXT NOT NULL, `Date` TEXT NOT NULL, `Lat` TEXT NOT NULL, `Lon` TEXT NOT NULL, `Status` TEXT NOT NULL, PRIMARY KEY(`Cases`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Country` (`Country` TEXT NOT NULL, `CountryCode` TEXT NOT NULL, `Date` TEXT NOT NULL, `NewConfirmed` INTEGER NOT NULL, `NewDeaths` INTEGER NOT NULL, `NewRecovered` INTEGER NOT NULL, `Slug` TEXT NOT NULL, `TotalConfirmed` INTEGER NOT NULL, `TotalDeaths` INTEGER NOT NULL, `TotalRecovered` INTEGER NOT NULL, PRIMARY KEY(`Country`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '349b74cab3a3a2df87dde8aeaa88ab25')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `LiveByCountryAndStatusItem`");
        _db.execSQL("DROP TABLE IF EXISTS `DayOneTotalResponseItem`");
        _db.execSQL("DROP TABLE IF EXISTS `Country`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsLiveByCountryAndStatusItem = new HashMap<String, TableInfo.Column>(10);
        _columnsLiveByCountryAndStatusItem.put("Active", new TableInfo.Column("Active", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLiveByCountryAndStatusItem.put("Confirmed", new TableInfo.Column("Confirmed", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLiveByCountryAndStatusItem.put("Country", new TableInfo.Column("Country", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLiveByCountryAndStatusItem.put("CountryCode", new TableInfo.Column("CountryCode", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLiveByCountryAndStatusItem.put("Date", new TableInfo.Column("Date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLiveByCountryAndStatusItem.put("Deaths", new TableInfo.Column("Deaths", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLiveByCountryAndStatusItem.put("Lat", new TableInfo.Column("Lat", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLiveByCountryAndStatusItem.put("LocationID", new TableInfo.Column("LocationID", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLiveByCountryAndStatusItem.put("Lon", new TableInfo.Column("Lon", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLiveByCountryAndStatusItem.put("Recovered", new TableInfo.Column("Recovered", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLiveByCountryAndStatusItem = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLiveByCountryAndStatusItem = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLiveByCountryAndStatusItem = new TableInfo("LiveByCountryAndStatusItem", _columnsLiveByCountryAndStatusItem, _foreignKeysLiveByCountryAndStatusItem, _indicesLiveByCountryAndStatusItem);
        final TableInfo _existingLiveByCountryAndStatusItem = TableInfo.read(_db, "LiveByCountryAndStatusItem");
        if (! _infoLiveByCountryAndStatusItem.equals(_existingLiveByCountryAndStatusItem)) {
          return new RoomOpenHelper.ValidationResult(false, "LiveByCountryAndStatusItem(com.android.ksih_covid_19_app.model.LiveByCountryAndStatusItem).\n"
                  + " Expected:\n" + _infoLiveByCountryAndStatusItem + "\n"
                  + " Found:\n" + _existingLiveByCountryAndStatusItem);
        }
        final HashMap<String, TableInfo.Column> _columnsDayOneTotalResponseItem = new HashMap<String, TableInfo.Column>(7);
        _columnsDayOneTotalResponseItem.put("Cases", new TableInfo.Column("Cases", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDayOneTotalResponseItem.put("Country", new TableInfo.Column("Country", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDayOneTotalResponseItem.put("CountryCode", new TableInfo.Column("CountryCode", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDayOneTotalResponseItem.put("Date", new TableInfo.Column("Date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDayOneTotalResponseItem.put("Lat", new TableInfo.Column("Lat", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDayOneTotalResponseItem.put("Lon", new TableInfo.Column("Lon", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDayOneTotalResponseItem.put("Status", new TableInfo.Column("Status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDayOneTotalResponseItem = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDayOneTotalResponseItem = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDayOneTotalResponseItem = new TableInfo("DayOneTotalResponseItem", _columnsDayOneTotalResponseItem, _foreignKeysDayOneTotalResponseItem, _indicesDayOneTotalResponseItem);
        final TableInfo _existingDayOneTotalResponseItem = TableInfo.read(_db, "DayOneTotalResponseItem");
        if (! _infoDayOneTotalResponseItem.equals(_existingDayOneTotalResponseItem)) {
          return new RoomOpenHelper.ValidationResult(false, "DayOneTotalResponseItem(com.android.ksih_covid_19_app.model.DayOneTotalResponseItem).\n"
                  + " Expected:\n" + _infoDayOneTotalResponseItem + "\n"
                  + " Found:\n" + _existingDayOneTotalResponseItem);
        }
        final HashMap<String, TableInfo.Column> _columnsCountry = new HashMap<String, TableInfo.Column>(10);
        _columnsCountry.put("Country", new TableInfo.Column("Country", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCountry.put("CountryCode", new TableInfo.Column("CountryCode", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCountry.put("Date", new TableInfo.Column("Date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCountry.put("NewConfirmed", new TableInfo.Column("NewConfirmed", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCountry.put("NewDeaths", new TableInfo.Column("NewDeaths", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCountry.put("NewRecovered", new TableInfo.Column("NewRecovered", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCountry.put("Slug", new TableInfo.Column("Slug", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCountry.put("TotalConfirmed", new TableInfo.Column("TotalConfirmed", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCountry.put("TotalDeaths", new TableInfo.Column("TotalDeaths", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCountry.put("TotalRecovered", new TableInfo.Column("TotalRecovered", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCountry = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCountry = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCountry = new TableInfo("Country", _columnsCountry, _foreignKeysCountry, _indicesCountry);
        final TableInfo _existingCountry = TableInfo.read(_db, "Country");
        if (! _infoCountry.equals(_existingCountry)) {
          return new RoomOpenHelper.ValidationResult(false, "Country(com.android.ksih_covid_19_app.model.Country).\n"
                  + " Expected:\n" + _infoCountry + "\n"
                  + " Found:\n" + _existingCountry);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "349b74cab3a3a2df87dde8aeaa88ab25", "d2abd84417c4094c181ecb32ae015a01");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "LiveByCountryAndStatusItem","DayOneTotalResponseItem","Country");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `LiveByCountryAndStatusItem`");
      _db.execSQL("DELETE FROM `DayOneTotalResponseItem`");
      _db.execSQL("DELETE FROM `Country`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public Covid19Dao covid19Dao() {
    if (_covid19Dao != null) {
      return _covid19Dao;
    } else {
      synchronized(this) {
        if(_covid19Dao == null) {
          _covid19Dao = new Covid19Dao_Impl(this);
        }
        return _covid19Dao;
      }
    }
  }
}
