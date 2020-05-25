package com.example.diplomepy.ui.glossary.addEditDictionary;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.diplomepy.databse.entities.DictModel;
import com.example.diplomepy.repositories.DictRepository;

public class AddEditDictViewModel extends AndroidViewModel {

    private final DictRepository dictRepository;
    private final MutableLiveData<String> error;
    private final MutableLiveData<String> success;

    public AddEditDictViewModel(@NonNull Application application) {
        super(application);
        dictRepository = new DictRepository(application);
        error = new MutableLiveData<>();
        success = new MutableLiveData<>();
    }

    LiveData<String> getSuccess(){
        return success;
    }

    LiveData<String> gerError(){
        return error;
    }

    void addDict(DictModel dictModel){

        if (dictModel.getInformation().isEmpty()){
            error.postValue("Введіть дані");
            return;
        }

        dictRepository.insert(dictModel);
        success.postValue("Збережено");
    }

    void updateDict(DictModel dictModel){


        dictRepository.update(dictModel);

        success.postValue("Зміни збережено");
    }



}
