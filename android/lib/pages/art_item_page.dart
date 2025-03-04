import 'package:flutter/material.dart';

import "package:android/models/models.dart";
import "package:android/network/art_item/get_art_item_service.dart";
import "package:android/network/art_item/get_art_item_output.dart";

class ArtItemPage extends StatefulWidget {
  final int id;

  const ArtItemPage({Key? key, required this.id}) : super(key: key);

  @override
  State<ArtItemPage> createState() => _ArtItemPageState();
}

class _ArtItemPageState extends State<ArtItemPage> {
  Scaffold erroneousArtItemPage() {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Art Item"),
      ),
      body: const Center(
        child: Text("Art Item Not Found"),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return FutureBuilder(
      future: getArtItemNetwork(widget.id),
      builder: (context, snapshot) {
        switch (snapshot.connectionState) {
          case ConnectionState.none:
          case ConnectionState.waiting:
            return const CircularProgressIndicator();
          default:
            if (snapshot.hasError) {
              return Scaffold(
                appBar: AppBar(
                  title: const Text("Snapshot Error!"),
                ),
                body: Center(
                  child: Text("Error: ${snapshot.error}"),
                ),
              );
            }

            if (snapshot.data != null) {
              GetArtItemOutput responseData = snapshot.data!;
              if (responseData.status != "OK") {
                return erroneousArtItemPage();
              }
              ArtItem currentArtItem = responseData.artItem!;
              return Scaffold(
                appBar: AppBar(
                  title: const Text("Art Item"),
                  backgroundColor: Colors.blue[300],
                ),
                body: Container(
                  color: Colors.blue[50],
                  child: Column(
                    children: [
                      Column(
                        children: [
                          Padding(
                              padding:
                                  const EdgeInsets.symmetric(horizontal: 12.0),
                              child: Column(
                                  crossAxisAlignment:
                                      CrossAxisAlignment.stretch,
                                  children: [
                                    const SizedBox(height: 10.0),
                                    Row(
                                      children: [
                                        Text(
                                          currentArtItem.artItemInfo.name,
                                          style: const TextStyle(
                                            fontSize: 20.0,
                                            fontWeight: FontWeight.w600,
                                          ),
                                          overflow: TextOverflow.ellipsis,
                                        ),
                                        const Spacer(),
                                        IconButton(
                                            onPressed: () {},
                                            icon: const Icon(
                                              Icons.bookmark_add_outlined,
                                              color: Colors.black,
                                              size: 30.0,
                                            )),
                                      ],
                                    ),
                                    Row(
                                      children: [
                                        const Icon(
                                          Icons.brush_outlined,
                                          color: Colors.black,
                                          size: 20.0,
                                        ),
                                        Text(
                                          " by ${currentArtItem.creator.name} ${currentArtItem.creator.surname}",
                                          style: const TextStyle(
                                            fontSize: 16.0,
                                            fontWeight: FontWeight.w600,
                                          ),
                                          overflow: TextOverflow.ellipsis,
                                        ),
                                        const Spacer(),
                                        Text(
                                          currentArtItem.artItemInfo.labels!
                                              .map((label) => label)
                                              .join(", "),
                                          style: const TextStyle(
                                            fontSize: 16.0,
                                            fontWeight: FontWeight.w400,
                                            fontStyle: FontStyle.italic,
                                          ),
                                          overflow: TextOverflow.ellipsis,
                                        ),
                                      ],
                                    ),
                                    const SizedBox(height: 15.0),
                                    currentArtItem.artItemInfo.imageUrl != null
                                        ? Container(
                                            height: 300.0,
                                            decoration: BoxDecoration(
                                              image: DecorationImage(
                                                image: NetworkImage(
                                                    currentArtItem
                                                        .artItemInfo.imageUrl!),
                                                fit: BoxFit.cover,
                                              ),
                                            ),
                                          )
                                        : Container(),
                                    const SizedBox(height: 15.0),
                                    Text(
                                      currentArtItem.artItemInfo.description,
                                      style: const TextStyle(
                                        fontSize: 16.0,
                                        fontWeight: FontWeight.w400,
                                      ),
                                    ),
                                    const SizedBox(height: 5.0),
                                    const Divider(color: Colors.black),
                                    const SizedBox(height: 5.0),
                                    Row(
                                      children:  [
                                        const Icon(Icons.chat, size: 13.0),
                                        const SizedBox(width: 5.0),
                                        Text(
                                          // TODO: Add number of comments
                                          "Comments (0)",
                                          style: TextStyle(
                                            fontSize: 16.0,
                                            fontWeight: FontWeight.w600,
                                          ),
                                        ),
                                        const Spacer(),
                                        IconButton(
                                            onPressed: () {},
                                            icon: const Icon(
                                              Icons.favorite_border,
                                              color: Colors.black,
                                              size: 30.0,
                                            )),
                                        IconButton(
                                            onPressed: () {},
                                            icon: const Icon(
                                              Icons.share,
                                              color: Colors.black,
                                              size: 30.0,
                                            )),
                                      ],
                                    ),
                                  ])),
                        ],
                      ),
                    ],
                  ),
                ),
              );
            } else {
              // snapshot.data == null
              return erroneousArtItemPage();
            }
        }
      },
    );
  }
}
