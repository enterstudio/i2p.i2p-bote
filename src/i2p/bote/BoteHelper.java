package i2p.bote;

import java.util.List;

import android.content.Context;

import i2p.bote.folder.EmailFolder;

public class BoteHelper {
    public static EmailFolder getMailFolder(String folderName) {
        List<EmailFolder> folders = I2PBote.getInstance().getEmailFolders();
        for (EmailFolder folder : folders) {
            if (folder.getName() == folderName)
                return folder;
        }
        return null;
    }

    /**
     * Get the translated name of the folder.
     * Built-in folders are special-cased; other folders are created by the
     * user, so their name is already "translated".
     * @param ctx Android Context to get strings from.
     * @param folder The folder.
     * @return The name of the folder.
     */
    public static String getFolderDisplayName(Context ctx, EmailFolder folder) {
        String name = folder.getName();
        if ("inbox".equals(name))
            return ctx.getResources().getString(R.string.folder_inbox);
        else if ("outbox".equals(name))
            return ctx.getResources().getString(R.string.folder_outbox);
        else if ("sent".equals(name))
            return ctx.getResources().getString(R.string.folder_sent);
        else if ("trash".equals(name))
            return ctx.getResources().getString(R.string.folder_trash);
        else
            return name;
    }
}
