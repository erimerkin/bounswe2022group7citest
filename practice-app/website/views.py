from flask import Blueprint, render_template, request

from .jwt import artist_token_required, user_token_required

views = Blueprint('views', __name__)


@views.route("/")
def home():
    return render_template("home.html")


@views.route("event/<event_id>/")
def view_event(event_id):
    return render_template("view_event.html", event_id=event_id)

@views.route("create_event/")
@artist_token_required
def create_event():
    return render_template("create_event.html")


@views.route("art_item/<art_item_id>/")
def view_art_item(art_item_id):
    return render_template("view_art_item.html", art_item_id=art_item_id)

@views.route("create_art_item/")
@artist_token_required
def create_art_item():
    return render_template("create_art_item.html")

@views.route("view_profile/")
@user_token_required
def view_profile():
    return render_template("view_profile.html")


@views.route('signup/')
def signup():
    return render_template('signup.html')


@views.route('login/')
def login():
    return render_template('login.html')

@views.route('participate/<event_id>/')
@user_token_required
def participate(event_id):
    return render_template('participate.html', event_id=event_id)
    
@views.route('art_galleries/')
def view_art_galleries():
    return render_template('art_galleries.html')
