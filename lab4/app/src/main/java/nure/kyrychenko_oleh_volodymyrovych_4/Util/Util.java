package nure.kyrychenko_oleh_volodymyrovych_4.Util;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nure.kyrychenko_oleh_volodymyrovych_4.DataSource.INoteDataSource;
import nure.kyrychenko_oleh_volodymyrovych_4.DataSource.NoteDataSource;

public final class Util {
    public static View findChildById(View view, int id) {
        if(!(view instanceof ViewGroup)) {
            return null;
        }

        ViewGroup group = ((ViewGroup)view);
        int childCount = group.getChildCount();

        for(int i = 0; i < childCount; ++i) {
            View found = findChildById(group.getChildAt(i), id);

            if(found != null) {
                return found;
            }
        }

        return null;
    }

    public static int Dp2Px(float dp, Context context) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics()
        );
    }

    public static INoteDataSource getNoteDataSource(Context context) {
        try {
            return new NoteDataSource(
                    URI.create(
                            context.getFilesDir().toURI().toString() + "/notes.json"
                    )
            );
        } catch (IOException e) {
            Toast.makeText(context, "Failed to open data source", Toast.LENGTH_SHORT).show();
            e.printStackTrace();

            return null;
        }
    }

    public static String FormatDate(Date date) {
        StringBuilder text = new StringBuilder();

        int day = date.getDate();
        if(day < 10) {
            text.append(0);
        }
        text.append(day).append(".");

        int month = date.getMonth();
        if(month < 10) {
            text.append(0);
        }
        text.append(month).append(".");
        text.append(date.getYear());

        return text.toString();
    }

    public static String FormatTime(Date time) {
        StringBuilder text = new StringBuilder();

        int hour = time.getHours();
        if(hour < 10) {
            text.append(0);
        }
        text.append(hour).append(":");

        int minute = time.getMinutes();
        if(minute < 10) {
            text.append(0);
        }
        text.append(minute);

        return text.toString();
    }

    public static boolean[] listToArray(List<Boolean> list) {
        int length = list.size();
        boolean[] arr = new boolean[length];
        for (int i = 0; i < length; i++)
            arr[i] = list.get(i);
        return arr;
    }

    public static List<Boolean> arrayToList(boolean[] array) {
        ArrayList<Boolean> list = new ArrayList<Boolean>();
        for (int i = 0; i < array.length; i++)
            list.add(array[i]);
        return list;
    }
}
