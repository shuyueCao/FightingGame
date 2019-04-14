# 角色系统

## 需求

1. 提供角色类型选择
   1. 提供怪物角色
2. 具有装备和武器加成
   1. 怪物无装备和武器以及防御值
3. 角色属性(血量、攻击力、防御)随着角色等级提升而提升

### 需求扩展

- 角色类型可扩展，后期可能增加角色种类
- 不同角色/怪物创建流程可能出现差异或创建流程将会变复杂
  - 创建角色/怪物的流程可能不断变复杂
  - 不同角色/怪物在细节之处可能不同

## 设计

#### 创建角色

- 角色初始无武器无装备，需要金钱购买
- 不同角色初始属性不同(血量、防御、攻击)
- 角色创建时不同部位可渲染不同的外观

**采用 `*工厂模式*` 创建角色，方便以后角色类型的扩展。**

**创建后角色采用 `*单例模式* `保证唯一性**

![icon](http://assets.processon.com/chart_image/5c98ed8ae4b0d1a5b10bf651.png?_=1555139745141)

**具体创建过程采用`*建造者模式*`进行创建角色，方便细节改变**

![icon](http://assets.processon.com/chart_image/5ae5e9bee4b0411f64d98975.png?_=1555141626442)

##### 实现结果
目前实现了工厂模式创建角色，未提供角色具体创建流程的差异性实现。

#### 创建怪物

- 不同怪物属性不同
  - 怪物没有防御值
- 怪物无升级体系

**采用 `*工厂模式*` 创建怪物，方便以后怪物类型的扩展。**

![icon](http://assets.processon.com/chart_image/5c98ed8ae4b0d1a5b10bf651.png?_=1555139978290)

##### 实现结果
目前实现了工厂模式创建怪物，未提供怪物具体创建流程的差异性实现。

#### 打怪
- 角色采用不同方法攻击时，会对怪物造成一定伤害。同时自身也会受到怪物的伤害。

**采用`*观察者模式*`实现，当怪物血量为0时，自动触发角色的相关属性的修改**

![icon][https://coding.net/u/phoebegl74/p/git_resource/git/raw/master/blog/pic.png]

##### 实现效果
实现了打怪胜利后角色相关属性的自动修改。

#### 角色升级

- 属性自动根据等级的提升而改变
  - 角色每升一级，属性(血量、攻击、防御值)相应提升
  - 角色每十级触发属性大幅增加(10级、20级......)

**采用`*状态模式*`实现，根据角色等级的状态来判断属性需要何种级别的提升**

![icon](http://assets.processon.com/chart_image/5c98f9b8e4b0d1a5b10bff52.png?_=1555142038798)

#### 实现结果

简化了属性提升，删除了属性大幅提升的功能。



# 装备/武器系统

## 需求

1. 武器可以加强
2. 装备可以镶嵌宝石以提供属性加成

### 需求扩展

- 武器、装备和宝石种类可能增加
- 武器栏数目、装备栏数目可能增加
- 装备可能需要镶嵌多个宝石

## 设计

### 购买武器/装备

- 一名角色对应一把武器和至多三件装备
  - 角色初始时默认无武器或装备
  - 武器和装备需要金钱购买
  - 超过武器栏数目/装备栏数目则无法购买武器/装备
- 武器和装备可以更换
- 武器的属性(攻击力)需要使用金币加强，更换武器后该武器的加成失效
  - 武器、装备属性与角色等级无关

- 装备的属性只能通过镶嵌宝石进行提升
- 不同武器和装备默认属性不同

**采用 `*工厂模式*` 创建装备和武器，方便武器类型和装备类型扩展，下图仅展示创建装备类图，创建武器类图与之类似**

![icon](http://assets.processon.com/chart_image/5c98ed8ae4b0d1a5b10bf651.png?_=1555139065904)

#### 实现结果

与设计相同

#### 装备镶嵌宝石

- 装备可以镶嵌宝石以增加属性(血量、防御)
  - 可以镶嵌多个
  - 宝石属性可叠加
- 宝石的创建使用工厂模式，类图类似上图

**采用`*装饰者模式*`实现，来保证镶嵌多个宝石的情况**

![icon](http://assets.processon.com/chart_image/5ae45c84e4b039625af641c7.png?_=1553529518955)

#### 实现结果

与设计相同


# 技能系统

## 需求

1. 每个角色三个技能，三技能为大招
2. 技能随着角色等级的提升而提升
3. 技能不同组合使用的效果不同

### 需求扩展

- 技能可能增加
- 组合可能有变化

## 设计

### 角色技能

- 每个角色均有技能一、技能二、技能三
  - 初始只有技能一，二级解锁技能二，三级解锁技能三

**采用`*策略模式*`实现角色技能，使得技能的实现独立于角色，且方便应对各个位置技能的变化**

![icon](http://assets.processon.com/chart_image/5c99a478e4b09bf72a682dd0.png?_=1553572974613)

#### 实现结果

- 角色技能使用了策略模式，与设计相同

- **在解锁技能部分采用了`*状态模式*`实现，根据角色等级状态判断是否需要解锁相应技能**

  ![icon](http://assets.processon.com/chart_image/5c99addfe4b09bf72a6835a7.png?_=1555143815942)

  

### 技能升级

- 角色等级每升5级，所有技能升一级(5级、15级....)
  - 技能每10级触发大幅增加技能属性(10级、20级.....)
- 技能等级提升伴随其属性(伤害)的提升

**采用`*观察者模式*`实现技能升级，角色技能每升5级，自动通知所有技能升级并改变其属性**

![icon](http://assets.processon.com/chart_image/5c99addfe4b09bf72a6835a7.png?_=1553575075661)

#### 实现结果

与设计相同

### 技能组合

- 不同命令实现不同技能组合
  - 不同的技能组合产生的效果不同

**采用`*命令模式*`实现技能组合，将多个技能封装到一个命令对象中**

![icon](http://assets.processon.com/chart_image/5c99bd98e4b0be36557f4d85.png?_=1553579039571)

#### 实现结果

与设计相同
