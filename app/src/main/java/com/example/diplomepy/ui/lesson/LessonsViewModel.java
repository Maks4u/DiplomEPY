package com.example.diplomepy.ui.lesson;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.diplomepy.databse.entities.BaseModel;
import com.example.diplomepy.databse.entities.ImageTestModel;
import com.example.diplomepy.databse.entities.TextTestModel;
import com.example.diplomepy.repositories.LessonRepository;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

class LessonsViewModel extends ViewModel {

    private final Application application;
    private final int id;
    private final LessonRepository lessonRepository;
    private final MediatorLiveData<List<BaseModel>> mediatorLiveData;
    private final MutableLiveData<List<BaseModel>> listMutableLiveData;

    private final MutableLiveData<List<ImageTestModel>> imageLiveData;
    private final MutableLiveData<List<TextTestModel>> textLiveData;

    LessonsViewModel(final Application application, int id) {

        this.id = id;
        this.application = application;

        lessonRepository = new LessonRepository(application);
        mediatorLiveData = new MediatorLiveData<>();

        listMutableLiveData = new MutableLiveData<>();

        imageLiveData = new MutableLiveData<>();
        textLiveData = new MutableLiveData<>();
    }

    MediatorLiveData<List<BaseModel>> getLessonList() {

        mediatorLiveData.addSource(lessonRepository.getAllPicture(id), imageTestModels -> {
            imageLiveData.setValue(getImageUrl(imageTestModels));
            setListMapper(getImageUrl(imageTestModels), textLiveData.getValue());
        });
        mediatorLiveData.addSource(lessonRepository.getAllText(id), textTestModels -> {
            textLiveData.setValue(combine(textTestModels));
            setListMapper(imageLiveData.getValue(), combine(textTestModels));
        });

        return mediatorLiveData;
    }

    private List<ImageTestModel> getImageUrl(final List<ImageTestModel> imageTestModels) {

        List<ImageTestModel> imageTestModel = new ArrayList<>();

        for (ImageTestModel img : imageTestModels) {
            String imgDir = "file:///android_asset/" + img.getPicture();

            InputStream is = null;

            try {
                is = application.getAssets().open(img.getPicture());

                imageTestModel.add(new ImageTestModel(img.getId_picture(), imgDir, img.getId_lesson()));

            } catch (Exception ignored) {

            } finally {
                try {
                    if (is != null)
                        is.close();
                } catch (Exception e) {
                    Log.v("APP", "some");
                }
            }
        }

        return imageTestModel;
    }


    private List<TextTestModel> combine(final List<TextTestModel> imageTestModels) {
        List<TextTestModel> data = new ArrayList<>();

        for (TextTestModel text : imageTestModels) {
            String[] split = text.getText().split("/:");
            for (String some : split) {
                TextTestModel textTestModel = new TextTestModel(text.getId_text(), some, text.getId_lesson());
                data.add(textTestModel);
            }
        }
        return data;
    }

    private void setListMapper(List<ImageTestModel> imageTestModels, List<TextTestModel> textTestModels) {

        List<BaseModel> list = new ArrayList<>();
        int counter = 0;

        if (imageTestModels != null && textTestModels != null) {
            for (TextTestModel textTestModel : textTestModels) {
                if (textTestModel.getText().equals("*")) {
                    if (counter < imageTestModels.size()) {
                        list.add(imageTestModels.get(counter));
                        counter++;
                    }
                } else {
                    list.add(textTestModel);
                }
            }

            mediatorLiveData.postValue(list);
        }
    }

}
