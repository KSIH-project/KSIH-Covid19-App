package com.android.ksih_covid_19_app.dataSource.local;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.android.ksih_covid_19_app.model.Country;
import com.android.ksih_covid_19_app.model.LiveByCountryAndStatusItem;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class Covid19Dao_Impl implements Covid19Dao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<LiveByCountryAndStatusItem> __insertionAdapterOfLiveByCountryAndStatusItem;

  private final EntityInsertionAdapter<Country> __insertionAdapterOfCountry;

  public Covid19Dao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLiveByCountryAndStatusItem = new EntityInsertionAdapter<LiveByCountryAndStatusItem>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `LiveByCountryAndStatusItem` (`Active`,`Confirmed`,`Country`,`CountryCode`,`Date`,`Deaths`,`Lat`,`LocationID`,`Lon`,`Recovered`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LiveByCountryAndStatusItem value) {
        stmt.bindLong(1, value.getActive());
        stmt.bindLong(2, value.getConfirmed());
        if (value.getCountry() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCountry());
        }
        if (value.getCountryCode() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCountryCode());
        }
        if (value.getDate() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDate());
        }
        stmt.bindLong(6, value.getDeaths());
        if (value.getLat() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getLat());
        }
        if (value.getLocationID() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getLocationID());
        }
        if (value.getLon() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getLon());
        }
        stmt.bindLong(10, value.getRecovered());
      }
    };
    this.__insertionAdapterOfCountry = new EntityInsertionAdapter<Country>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Country` (`Country`,`CountryCode`,`Date`,`NewConfirmed`,`NewDeaths`,`NewRecovered`,`Slug`,`TotalConfirmed`,`TotalDeaths`,`TotalRecovered`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Country value) {
        if (value.getCountry() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCountry());
        }
        if (value.getCountryCode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCountryCode());
        }
        if (value.getDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDate());
        }
        stmt.bindLong(4, value.getNewConfirmed());
        stmt.bindLong(5, value.getNewDeaths());
        stmt.bindLong(6, value.getNewRecovered());
        if (value.getSlug() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getSlug());
        }
        stmt.bindLong(8, value.getTotalConfirmed());
        stmt.bindLong(9, value.getTotalDeaths());
        stmt.bindLong(10, value.getTotalRecovered());
      }
    };
  }

  @Override
  public Object setLiveByCountryAndStatus(final List<LiveByCountryAndStatusItem> responseList,
      final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfLiveByCountryAndStatusItem.insert(responseList);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object setCountryAndNewCasesList(final List<Country> countryList,
      final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCountry.insert(countryList);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public LiveData<List<LiveByCountryAndStatusItem>> getLiveByCountryAndStatus() {
    final String _sql = "SELECT * FROM LiveByCountryAndStatusItem";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"LiveByCountryAndStatusItem"}, false, new Callable<List<LiveByCountryAndStatusItem>>() {
      @Override
      public List<LiveByCountryAndStatusItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "Active");
          final int _cursorIndexOfConfirmed = CursorUtil.getColumnIndexOrThrow(_cursor, "Confirmed");
          final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "Country");
          final int _cursorIndexOfCountryCode = CursorUtil.getColumnIndexOrThrow(_cursor, "CountryCode");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "Date");
          final int _cursorIndexOfDeaths = CursorUtil.getColumnIndexOrThrow(_cursor, "Deaths");
          final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "Lat");
          final int _cursorIndexOfLocationID = CursorUtil.getColumnIndexOrThrow(_cursor, "LocationID");
          final int _cursorIndexOfLon = CursorUtil.getColumnIndexOrThrow(_cursor, "Lon");
          final int _cursorIndexOfRecovered = CursorUtil.getColumnIndexOrThrow(_cursor, "Recovered");
          final List<LiveByCountryAndStatusItem> _result = new ArrayList<LiveByCountryAndStatusItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final LiveByCountryAndStatusItem _item;
            final int _tmpActive;
            _tmpActive = _cursor.getInt(_cursorIndexOfActive);
            final int _tmpConfirmed;
            _tmpConfirmed = _cursor.getInt(_cursorIndexOfConfirmed);
            final String _tmpCountry;
            _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
            final String _tmpCountryCode;
            _tmpCountryCode = _cursor.getString(_cursorIndexOfCountryCode);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            final int _tmpDeaths;
            _tmpDeaths = _cursor.getInt(_cursorIndexOfDeaths);
            final String _tmpLat;
            _tmpLat = _cursor.getString(_cursorIndexOfLat);
            final String _tmpLocationID;
            _tmpLocationID = _cursor.getString(_cursorIndexOfLocationID);
            final String _tmpLon;
            _tmpLon = _cursor.getString(_cursorIndexOfLon);
            final int _tmpRecovered;
            _tmpRecovered = _cursor.getInt(_cursorIndexOfRecovered);
            _item = new LiveByCountryAndStatusItem(_tmpActive,_tmpConfirmed,_tmpCountry,_tmpCountryCode,_tmpDate,_tmpDeaths,_tmpLat,_tmpLocationID,_tmpLon,_tmpRecovered);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Country>> getCountryAndNewCasesListLocal() {
    final String _sql = "SELECT * FROM Country";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Country"}, false, new Callable<List<Country>>() {
      @Override
      public List<Country> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "Country");
          final int _cursorIndexOfCountryCode = CursorUtil.getColumnIndexOrThrow(_cursor, "CountryCode");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "Date");
          final int _cursorIndexOfNewConfirmed = CursorUtil.getColumnIndexOrThrow(_cursor, "NewConfirmed");
          final int _cursorIndexOfNewDeaths = CursorUtil.getColumnIndexOrThrow(_cursor, "NewDeaths");
          final int _cursorIndexOfNewRecovered = CursorUtil.getColumnIndexOrThrow(_cursor, "NewRecovered");
          final int _cursorIndexOfSlug = CursorUtil.getColumnIndexOrThrow(_cursor, "Slug");
          final int _cursorIndexOfTotalConfirmed = CursorUtil.getColumnIndexOrThrow(_cursor, "TotalConfirmed");
          final int _cursorIndexOfTotalDeaths = CursorUtil.getColumnIndexOrThrow(_cursor, "TotalDeaths");
          final int _cursorIndexOfTotalRecovered = CursorUtil.getColumnIndexOrThrow(_cursor, "TotalRecovered");
          final List<Country> _result = new ArrayList<Country>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Country _item;
            final String _tmpCountry;
            _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
            final String _tmpCountryCode;
            _tmpCountryCode = _cursor.getString(_cursorIndexOfCountryCode);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            final int _tmpNewConfirmed;
            _tmpNewConfirmed = _cursor.getInt(_cursorIndexOfNewConfirmed);
            final int _tmpNewDeaths;
            _tmpNewDeaths = _cursor.getInt(_cursorIndexOfNewDeaths);
            final int _tmpNewRecovered;
            _tmpNewRecovered = _cursor.getInt(_cursorIndexOfNewRecovered);
            final String _tmpSlug;
            _tmpSlug = _cursor.getString(_cursorIndexOfSlug);
            final int _tmpTotalConfirmed;
            _tmpTotalConfirmed = _cursor.getInt(_cursorIndexOfTotalConfirmed);
            final int _tmpTotalDeaths;
            _tmpTotalDeaths = _cursor.getInt(_cursorIndexOfTotalDeaths);
            final int _tmpTotalRecovered;
            _tmpTotalRecovered = _cursor.getInt(_cursorIndexOfTotalRecovered);
            _item = new Country(_tmpCountry,_tmpCountryCode,_tmpDate,_tmpNewConfirmed,_tmpNewDeaths,_tmpNewRecovered,_tmpSlug,_tmpTotalConfirmed,_tmpTotalDeaths,_tmpTotalRecovered);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
