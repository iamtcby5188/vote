// pages/vote_single/vote_single.js
const app = getApp()
const constant = require("../../utils/constant.js")
const util = require("../../utils/util.js")
Page({

  /**
   * 页面的初始数据
   */
  data: {
    del_ico_src:"../../resources/common/del_ico.png",
    add_ico_src:"../../resources/common/add_ico.jpg",
    topic:{
      text:"",
      placeholder:"投票标题"
    },
    description:{
      text:"",
      placeholder:"补充描述"
    },
    item_list:[
      {
        text:"",
        placeholder:"选项1",
      },
      {
        text:"",
        placeholder:"选项2",
      }
    ],
    date: '2016-09-01',
    time: '23:59',
    vote_type: constant.golable_variable.vote_single,
    saveSuccess:false
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
      this.setData({vote_type:options.type})
      console.log(options.type)
      wx.setNavigationBarTitle({
        title: options.type == constant.golable_variable.vote_single ? "创建单选投票单" : "创建多选投票单", 
      })
      var curDate = new Date()
      this.setData({ date:util.formatTime(curDate,"yyyy-MM-dd")})
      wx.hideShareMenu()
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function (e) {
    return {
      title:"邀请好友投票",
      success :res=>{
        wx.navigateBack();
      },
      fail: res=>{
      }
    }
   },
  topicChanges:function(e){
    this.setData({"topic.text": e.detail.value})
  },
  descriptionChanges:function(e){
    this.setData({"description.text":e.detail.value})
  },
  itemChanges:function(e){
    var modify_index = parseInt(e.target.id)
    this.data.item_list[modify_index].text = e.detail.value
  },
  addItems:function(){
     this.data.item_list.push({text:"",placeholder:""});
     for(var i = 0 ; i < this.data.item_list.length;++i){
          this.data.item_list[i].placeholder = "选项" + (i+1);
     }

    this.setData({item_list:this.data.item_list})
  },
  clickdelitem:function(e){
    var del_index = parseInt(e.target.id)
    console.log(del_index);
    this.data.item_list.splice(del_index,1);
    for (var i = 0; i < this.data.item_list.length; ++i) {
      this.data.item_list[i].placeholder = "选项" + (i + 1);
    }
    this.setData({item_list:this.data.item_list})
  },
  bindDateChange: function (e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      date: e.detail.value
    })
  },
  bindTimeChange: function (e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      time: e.detail.value
    })
  },
  clickComplete:function(){
    if(this.data.topic.text.length <= 0){
      wx.showModal({
        title: '提示',
        content: '主题为空',
        showCancel:false
      })
      return;
    }
    if (this.data.description.text.length<=0){
      //return;
    }

    let vote_info = {
      create_user: app.globalData.userInfo.id,
      vote_topic: this.data.topic.text,
      vote_description: this.data.description.text,
      vote_type:this.data.vote_type,
      dead_line:this.data.date +" "+ this.data.time + ":00",
      lst_vote_option:[]
    }

    var hasOption = false;
    for(let i = 0 ; i <this.data.item_list.length;++i){
      if(this.data.item_list[i].text.length>0){
        vote_info.lst_vote_option.push({vote_option:this.data.item_list[i].text})
        hasOption = true
      }
    }

    if(!hasOption){
      wx.showModal({
        title: '提示',
        content: '至少有一个选项',
        showCancel: false
      })
      return;
    }
    wx.request({
      url: constant.getUrl(constant.request_url.addNewVote),
      data:vote_info,
      method: 'POST',
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: res=>{
        this.setData({
          'saveSuccess': true
        })
      },
      fail:res=>{}
      })
  }
})