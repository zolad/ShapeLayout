ShapeLayout
==============
Custom shaped layout for Android 自定义形状布局


![screenshot1~](https://raw.github.com/zolad/ShapeLayout/master/screenshot/screenshot_1.gif)

Features
==============
- Clip layout and its childview.
- 2 way to set shape.
- Also custom shape by implement ShapeModel.

Dependency
==============
### Add this in your build.gradle file 
```gradle
compile 'com.zolad:shapelayout:1.0.0'
```

Usage
==============
### 1.layout xml

```java

  <com.zolad.shapelayout.ShapeLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

       //your layout

  </com.zolad.shapelayout.ShapeLayout>
  
```


### 2.Set a ShapeModel, a drawable or a path


```java

  Drawable shapeDrawable = getResources().getDrawable(R.drawable.pic_shape);
  shapeLayout.setShapeModel(new DrawableShapeModel(shapeDrawable));
  
```

or

```java

  shapeLayout.setShapeModel(new ClipPathShapeModel(new ClipPathShapeModel.OnClipPath() {
            @Override
            public Path setClipPath(int canvasWidth, int canvasHeight) {
            
                Path path = new Path();
                ...
                path.close();
                return path;
            }
        }));
        
```


License
==============

    Copyright 2018 Zolad

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
