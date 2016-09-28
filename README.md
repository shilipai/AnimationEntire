# AnimationEntire
##动画全解##
- 补间动画(Tween)
- 帧动画(Frame)
- 属性动画(Property)

> 补间动画与帧动画都属于View动画，不同的资料分类不同，可能给初学者造成困惑，其实，无所谓了，概念而已。看到（）里的英文了吗，知道这些就足够了。（旅行社lxs说）

1. 用最简单的Activity进行页面跳转，什么是Fragment，初学者就应该集中精力学习核心的东西。
2. 相对简单的部分，会介绍一些代码中的坑与注意事项，相对有难度的地方会用最简单的实现进行讲解，理由：因为你每次只看简单的，都没你看烂了，因为你每次遇到难度都看不下去了，再一次把你吓跑，（旅行社lxs）没那么傻 ！

## 补间动画 ##
```
// 核心代码
anim = AnimationUtils.loadAnimation(this, R.anim.rotate);
btnRotate.startAnimation(anim);
```

> View动画建议采用XML定义动画，因为其可读性更好

## 帧动画 ##
```
// 核心代码
tvAnimationFrame.setBackgroundResource(R.drawable.frame);// Why 1?
anim = (AnimationDrawable) tvAnimationFrame.getBackground();//Why 2?
```

 1. getResources().getDrawable()不推荐使用了（Deprecated）-->用ContextCompat.getDrawable(this, R.drawable.frame);代替。具体查看：[getDrawable()过时用何代替](http://stackoverflow.com/questions/29041027/android-getresources-getdrawable-deprecated-api-22)
 2. setBackgroundDrawable(anim)同样过时-->用tvAnimationFrame.setBackgroundResource(R.drawable.frame);代替。具体查看：[setBackgroundDrawable()过时用何代替](http://www.lai18.com/content/666597.html)

> 旅行社（lxs）说：
> stackoverflow是个强大的网站，有问题就问他，大部分能给你答案。另外，能看英文的文章就看英文的文章，第一、可以练习一下英语（看不懂英文，有道翻译啊。不要为自己的懒惰找借口），第二、英文文章的质量还是好一点，哪怕是国人用英语写的文章（敢用英文写已经说明了实力，起码技术过硬才有时间用英语写）。

## 属性动画 ##
> 属性动画可以对任意对象的属性进行动画而不仅仅是View,动画的默认时间间隔是300ms，默认帧率10ms/帧。

