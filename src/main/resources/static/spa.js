const table = document.getElementById("tableBud");
const submitbutton = document.getElementById("submitbuddy");

const addressBookBuddiesLink = null;
function addNewBuddy(e) {
    e.preventDefault();
    let name = document.getElementById("buddyName").value;
    let buddyNumber = document.getElementById("buddyNumber").value;

    fetch('http://localhost:8080/addressbook', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "name": name,
            "phoneNumber": buddyNumber
        })
    }).then(function (value) {
        value.json().then(function (buddy) {
            var buddyAddressBookUrl = buddy._links.addressBook.href;

            fetch(buddyAddressBookUrl, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'text/uri-list'
                },
                body: addressBookBuddiesLink
            }).then(function (value1) {
                //the ui is nto working
            })
        });
    });
}

=

submitbutton.addEventListener("click", addNewBuddy);