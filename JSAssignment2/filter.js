var arr=["entree","desserts","main course","appetizers","beverages"];
function search(){
    var searchfilter=document.getElementById("tosearch").value;
    searchfilter=searchfilter.toLowerCase();
    console.log(searchfilter);
    if(searchfilter==""){
        allItemsVisible();
    }
    if(arr.includes(searchfilter)){
        displayMenu(searchfilter);
    }
    else{
        var allitems=document.getElementsByClassName("item");
        console.log(allitems);
        for(var k=0;k<allitems.length;k++){

            if(allitems[k].textContent.toLowerCase().indexOf(searchfilter)!=-1){
                allitems[k].style.display='block';
            }
            else{
                allitems[k].style.display='none';
            }
        }
    }
}
function allItemsVisible(){
    for(let j=0;j<arr.length;j++){
        document.getElementById(arr[j]).style.display='block';
    }
    let allItems=document.getElementsByClassName("item");
    for(let i=0;i<allItems.length;i++){
        allItems[i].style.display='block';
    }
}
function displayMenu(x){
    allItemsVisible();
    for(var i=0;i<arr.length;i++){
        if(arr[i]==x){
            document.getElementById(x).style.display='block';
        }
        else{
            document.getElementById(arr[i]).style.display='none';
        }
    }
}
function tablesearch(){
    var tablesearchfilter=document.getElementById("tablesearch").value;
    console.log(tablesearchfilter);
    tablesearchfilter=tablesearchfilter.toLowerCase();
    var tableitems=document.getElementsByClassName("tableitem");
    console.log(tableitems);
    for(var k=0;k<tableitems.length;k++){
        if(tableitems[k].textContent.toLowerCase().slice(0,7).indexOf(tablesearchfilter)!=-1){
            tableitems[k].style.display='block';
        }
        else{
            tableitems[k].style.display='none';
        }
    }

}
function allowDrop(ev) {
    ev.preventDefault();
  }
  
  function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.id);
    
  }
  
  function drop(ev,target) {
    ev.preventDefault();
    var data = ev.dataTransfer.getData("text");
    console.log(target.id);
    console.log(data);
    let item=document.getElementById(data).textContent;
    console.log(target.id);
    var setTableId=target.id.replace('able','');
    var vals=item.split(" Rs-");
    console.log(vals);
    let itemcount=1;
    var itemexists=false;
    let tbodies=document.getElementById(setTableId).getElementsByTagName("tbody");
    console.log(tbodies.length);
    for(var i=0;i<tbodies.length;i++){
        let tr=tbodies[i].children[0];
        let itemname=tr.children[0].textContent;
        console.log(itemname);
        if(itemname==vals[0]){
            itemexists=true;
            alert(vals[0]+" is already in the "+target.id);
            break;
        } 
    }
    let quantity=1;
    let inpId=setTableId+"i"+document.getElementById(setTableId).rows.length; 
    if(itemexists==false){
    alert(vals[0]+" has been added to "+target.id);
    console.log(document.getElementById(setTableId).innerHTML);
    document.getElementById(setTableId).innerHTML+=`<tr><td>${vals[0]}</td><td>${vals[1]}</td><td><input type="number" id=${inpId} value=${quantity}  min='1' max='10' onChange="setQuantity(this); calculateTotal('${setTableId}'); "></td><td><a onclick="deleteItem(this,'${setTableId}')"><div class="w3-padding w3-xlarge w3-text-black">
    <i class="material-icons">delete</i>
  </div></a></td></tr>`;   
  }
  var itemsId="nitems"+setTableId;
  var noOfItems=document.getElementById(setTableId).rows.length-1;
  document.getElementById(itemsId).innerHTML=`Items : ${noOfItems}`;
  calculateTotal(setTableId);
}
function setQuantity(ele){
    let quantity=ele.value;
    if(quantity<0 || quantity>10){
        alert("Minimum order 1 and Maximum orders is 10");
        ele.defaultValue=1;
        ele.value=1;
    }
    else{
    ele.defaultValue=quantity;
    }
    console.log(ele);

}
function calculateTotal(setTableId){
    
    var totalId="total"+setTableId;
    var ans=0;
    console.log(totalId);
    console.log(setTableId);
  var Rows=document.getElementById(setTableId).rows;
  var noOfItems=Rows.length-1;
  for(let k=1;k<Rows.length;k++){
      
      let inpId=Rows[k].children[2].children[0].id;
      let price=parseInt(Rows[k].children[1].textContent);
    ans+=price*parseInt(document.getElementById(inpId).value);
  }
  var itemsId="nitems"+setTableId;
  document.getElementById(itemsId).innerHTML=`Items : ${Rows.length-1}`
  document.getElementById(totalId).innerHTML=`Total : ${ans}`;
}
function deleteItem(ele,id){
    ele.parentElement.parentElement.parentElement.remove();
    calculateTotal(id);
}
function showTable(id){
    var viewId="view"+id.slice(1);
    document.getElementById(viewId).style.display='none';
    var bId='b'+id.slice(1);
    document.getElementById(bId).style.display='block';
    document.getElementById(id).style.display='block';
}
function resetTable(id){
    document.getElementById(id).innerHTML=`<thead><tr>
    <th>Item</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>delete</th>
</tr></thead>`
calculateTotal(id);
console.log(id);
let viewId="view"+id.slice(1);
let bId="b"+id.slice(1);
document.getElementById(id).style.display='none';
document.getElementById(bId).style.display='none';
document.getElementById(viewId).style.display='block';
}