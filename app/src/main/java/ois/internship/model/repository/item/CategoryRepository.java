package ois.internship.model.repository.item;

import java.util.ArrayList;

import ois.internship.model.entity.CategoryEntity;
import ois.internship.model.repository.BaseRepository;

public class CategoryRepository extends BaseRepository {

    private ArrayList<CategoryEntity> categoryList;

    //=============================================================================
    // Constracter
    //=============================================================================
    public CategoryRepository(){
        categoryList = new ArrayList<>();
    }

    //=============================================================================
    // public
    //=============================================================================

    /**
     * カテゴリーセット
     * @param data
     */
    public void set(ArrayList<CategoryEntity> data){
        this.categoryList= data;
    }


    //=============================================================================
    // getter
    //=============================================================================

    /**
     * カテゴリ数を取得
     * @return
     */
    public int categorySize() {
        return categoryList.size();
    }


}

