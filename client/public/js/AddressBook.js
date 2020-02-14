$(document).ready(function() {
    getAddressBooks();
    $("#createAddressBook").click(createAddressBook);
});

function createAddressBook(){
    $.ajax({
        type:"POST",
        url: "http://localhost:8081/rest/addAddressbook"
    }).then(function(data) {
        getAddressBooks();
    });
}

function getAddressBooks() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8081/rest/getAddressBooks"
    }).then(function(data) {
        console.log(data);
        var table = $("#AddressBooks");
        if (data != null && data.length != 0){
            $(table).empty();
            for (var i in data){
                $(table).append("<tr><td>Address Book ID " + data[i].id + "</td></tr>")
            }
        }
        else if(data.length == 0){
            $(table).html = ("<p>No AddressBooks found.</p>");
        }
    });
}